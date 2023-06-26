package ltd.newimg;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import java.io.IOException;
import java.util.ArrayList;

public class Get {
    public static void main(String[] args) throws IOException {
        // 初始化snmp agent
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();
        // 初始化并设置communityTarget
        CommunityTarget communityTarget = new CommunityTarget(GenericAddress.parse("udp:127.0.0.1/161"), new OctetString("public")) {{
            setRetries(3);
            setTimeout(1500);
            setVersion(SnmpConstants.version1);
        }};
        // 初始化并设置PDU
        PDU pdu = new PDU() {{
            add(new VariableBinding(new OID(new int[]{1, 3, 6, 1, 2, 1, 1, 4, 0})));
            setType(PDU.GET);
        }};
        // 发送并接收响应
        ResponseEvent responseEvent = snmp.send(pdu, communityTarget);
        if (responseEvent != null && responseEvent.getResponse() != null) {
            ArrayList<VariableBinding> respVBs = (ArrayList<VariableBinding>) responseEvent.getResponse().getVariableBindings();
            for (VariableBinding respVB : respVBs) {
                System.out.println(respVB.getOid() + ": " + respVB.getVariable());
            }
        }
    }
}