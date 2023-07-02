package ltd.newimg;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.smi.Address;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import java.io.IOException;

public class Handler {
    Snmp snmp = null;
    TransportMapping transport = null;
    CommunityTarget communityTarget;
    public Address init(CommunityTarget communityTarget) throws IOException {
        // 初始化并设置communityTarget
        this.communityTarget = communityTarget;
        return transport.getListenAddress();
    }
    public ResponseEvent execute(PDU pdu) throws IOException {
        return snmp.send(pdu, communityTarget);
    }
    public Handler() {
        try {
            // 初始化snmp agent
            transport = new DefaultUdpTransportMapping();
            snmp = new Snmp(transport);
            transport.listen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

