package ltd.newimg;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import java.io.IOException;
import java.util.ArrayList;

public class Set {
    public static void main(String[] args) throws IOException {
        // 初始化snmp agent
        TransportMapping transport = new DefaultUdpTransportMapping();
        Snmp snmp = new Snmp(transport);
        transport.listen();
        // 初始化并设置communityTarget
        CommunityTarget communityTarget = new CommunityTarget(GenericAddress.parse("udp:127.0.0.1/161"), new OctetString("Fuwrtie")) {{
            setRetries(3);
            setTimeout(1500);
            setVersion(SnmpConstants.version1);
        }};
        get(snmp, communityTarget, new OID(new int[]{1, 3, 6, 1, 2, 1, 1, 4, 0}), "Before");
        set(snmp, communityTarget, new OID(new int[]{1, 3, 6, 1, 2, 1, 1, 4, 0}), new OctetString("04202084-set"), "Setting");
        get(snmp, communityTarget, new OID(new int[]{1, 3, 6, 1, 2, 1, 1, 4, 0}), "After");
    }

    private static void set(Snmp snmp, CommunityTarget communityTarget, OID oid, Variable variable, String before) throws IOException {
        PDU pdu = new PDU() {{
            add(new VariableBinding(oid, variable));
            setType(PDU.SET);
        }};
        // 发送并接收响应
        ResponseEvent responseEvent = snmp.send(pdu, communityTarget);
        if (responseEvent != null && responseEvent.getResponse() != null) {
            ArrayList<VariableBinding> respVBs = (ArrayList<VariableBinding>) responseEvent.getResponse().getVariableBindings();
            for (VariableBinding respVB : respVBs) {
                System.out.println("[" + before + "]" + respVB.getOid() + ": " + respVB.getVariable());
            }
        }
    }

    private static void get(Snmp snmp, CommunityTarget communityTarget, OID oid, String before) throws IOException {
        // 初始化并设置PDU
        PDU pdu = new PDU() {{
            add(new VariableBinding(oid));
            setType(PDU.GET);
        }};
        // 发送并接收响应
        ResponseEvent responseEvent = snmp.send(pdu, communityTarget);
        if (responseEvent != null && responseEvent.getResponse() != null) {
            ArrayList<VariableBinding> respVBs = (ArrayList<VariableBinding>) responseEvent.getResponse().getVariableBindings();
            for (VariableBinding respVB : respVBs) {
                System.out.println("[" + before + "]" + respVB.getOid() + ": " + respVB.getVariable());
            }
        }
    }
}