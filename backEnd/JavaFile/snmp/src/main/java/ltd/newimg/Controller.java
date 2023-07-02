package ltd.newimg;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {

    static Handler handler = new Handler();
    static Scanner scanner = new Scanner(System.in);
    static Boolean hasInit = false;
    static Address address = null;

    public static void main(String[] args) {
        while (true) {
            flush();
            if (hasInit) {
                System.out.println("Source Address: " + address);
            }
            System.out.println("" + "=============================================\n" + String.format("\t%s\t\n", "功能菜单") + String.format("\t%s\t\n", "[0]Exit") + String.format("\t%s\t\n", "[1]SNMP-Setting") + String.format("\t%s\t\n", "[2]SNMPv1-Get") + String.format("\t%s\t\n", "[3]SNMPv1-GetNext") + String.format("\t%s\t\n", "[4]SNMPv2c-GetBulk") + String.format("\t%s\t\n", "[5]SNMPv1-Set") + String.format("\t%s\t\n", "[6]trap") + "=============================================");
            switch (getString("请输入选项[0-6]:").substring(0, 1)) {
                case "1":
                    init();
                    break;
                case "2":
                    get();
                    break;
                case "3":
                    getNext();
                    break;
                case "4":
                    getBulk();
                    break;
                case "5":
                    set();
                    break;
                case "6":
                    trap();
                    break;
                default:
                    System.exit(0);
            }
            pause();
        }
    }

    public static boolean init() {
        try {
            if (getChoice("use Default?", true)) {
                address = handler.init(new CommunityTarget() {{
                    setAddress(GenericAddress.parse("udp:127.0.0.1/161"));
                    setCommunity(new OctetString("public"));
                    setRetries(3);
                    setTimeout(1500);
                    setVersion(SnmpConstants.version1);
                }});
            } else {
                address = handler.init(new CommunityTarget() {{
                    setAddress(GenericAddress.parse(getString("Address?(e.g.: udp:127.0.0.1/161)")));
                    setCommunity(new OctetString(getString("Community?(e.g.: public)")));
                    setTimeout(getInt("Timeout?(e.g.: 10)"));
                    setRetries(getInt("Retries?(e.g.: 3)"));
                    setVersion(getInt("Version?[1-2]") == 1 ? SnmpConstants.version1 : SnmpConstants.version2c);
                }});
            }
            hasInit = true;
            return true;
        } catch (IOException e) {
            System.out.println("[Warn] 初始化失败");
            new Thread(() -> {
                throw new RuntimeException(e);
            }).start();
            return false;
        }
    }

    public static void get() {
        try {
            parse(handler.execute(new PDU() {{
                setType(PDU.GET);
                add(new VariableBinding(new OID(stringToInts(getString("OID?(e.g.: 1.3.6.1.2.1.1.5.0)")))));
            }}));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getNext() {
        try {
            parse(handler.execute(new PDU() {{
                setType(PDU.GETNEXT);
                add(new VariableBinding(new OID(stringToInts(getString("OID?(e.g.: 1.3.6.1.2.1.1.5.0)")))));
            }}));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getBulk() {
        try {
            parse(handler.execute(new PDU() {{
                setType(PDU.GETBULK);
                setNonRepeaters(getInt("NonRepeaters?"));
                setMaxRepetitions(getInt("MaxRepeaters?"));
                while (getChoice("hasNext?", true)) {
                    add(new VariableBinding(new OID(stringToInts(getString("OID?(e.g.: 1.3.6.1.2.1.1.5.0)")))));
                }
            }}));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void set() {
        try {
            parse(handler.execute(new PDU() {{
                setType(PDU.SET);
                add(new VariableBinding(
                        new OID(stringToInts(getString("OID?(e.g.: 1.3.6.1.2.1.1.5.0)"))), new OctetString(getString("value?")))
                );
            }}));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void trap() {
        SnmpTrapMultiThreadReceiver trapReceiver = new SnmpTrapMultiThreadReceiver();
        trapReceiver.run();
    }

    public static void parse(ResponseEvent responseEvent) {
        if (responseEvent != null && responseEvent.getResponse() != null) {
            ArrayList<VariableBinding> respVBs = (ArrayList<VariableBinding>) responseEvent.getResponse().getVariableBindings();
            for (VariableBinding respVB : respVBs) {
                System.out.println(respVB.getOid() + ": " + respVB.getVariable());
            }
        }
    }

    public static Integer getInt(String prompt) {
        System.out.println(prompt);
        return scanner.nextInt();
    }

    public static String getString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static Boolean getChoice(String prompt, boolean def) {
        System.out.println(prompt + (def ? "(Y/n)" : "(N/y)"));
        String s = scanner.nextLine();
        if (s == null || s.length() == 0) {
            return def;
        } else {
            return s.equalsIgnoreCase("Y");
        }
    }

    public static int[] stringToInts(String str) {
        String[] strArr = str.split("\\.");
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    public static void flush() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause() {
        getString("----------按回车继续----------");
    }
}
