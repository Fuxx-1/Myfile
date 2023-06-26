package ltd.newimg;

import org.snmp4j.*;
import org.snmp4j.mp.MPv1;
import org.snmp4j.mp.MPv2c;
import org.snmp4j.mp.MPv3;
import org.snmp4j.security.SecurityModels;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.security.USM;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.MultiThreadedMessageDispatcher;
import org.snmp4j.util.ThreadPool;

import java.io.IOException;
import java.net.UnknownHostException;

public class SnmpTrapMultiThreadReceiver implements CommandResponder {
    private MultiThreadedMessageDispatcher dispatcher;
    private Snmp snmp = null;
    private Address listenAddress;
    private ThreadPool threadPool;

    public SnmpTrapMultiThreadReceiver() {
    }

    private void init() throws UnknownHostException, IOException {
        threadPool = ThreadPool.create("TrapPool", 2);
        dispatcher = new MultiThreadedMessageDispatcher(threadPool,
                new MessageDispatcherImpl());
        listenAddress = GenericAddress.parse(System.getProperty(
                "snmp4j.listenAddress", "udp:127.0.0.1/162"));
        TransportMapping transport = new DefaultUdpTransportMapping((UdpAddress) listenAddress);
//        if (listenAddress instanceof UdpAddress) {
//            transport = new DefaultUdpTransportMapping((UdpAddress) listenAddress);
//        } else {
//            transport = new DefaultTcpTransportMapping((TcpAddress) listenAddress);
//        }
        snmp = new Snmp(dispatcher, transport);
        snmp.getMessageDispatcher().addMessageProcessingModel(new MPv1());
        snmp.getMessageDispatcher().addMessageProcessingModel(new MPv2c());
        snmp.getMessageDispatcher().addMessageProcessingModel(new MPv3());
        USM usm = new USM(SecurityProtocols.getInstance(), new OctetString(
                MPv3.createLocalEngineID()), 0);
        SecurityModels.getInstance().addSecurityModel(usm);
        snmp.listen();
    }

    public void run() {
        try {
            init();
            snmp.addCommandResponder(this);
            System.out.println("Waiting Trap......");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void processPdu(CommandResponderEvent event) {
        System.out.println("Start parsing......");
        if (event == null || event.getPDU() == null) {
            System.out.println("[Warn] PDU is null");
            return;
        }
        System.out.println(event.getPDU());
        System.out.println("Parsing over......");
    }

    public static void main(String[] args) {
        SnmpTrapMultiThreadReceiver trapReceiver = new SnmpTrapMultiThreadReceiver();
        trapReceiver.run();
    }
}