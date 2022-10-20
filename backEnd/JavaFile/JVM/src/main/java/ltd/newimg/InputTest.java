package ltd.newimg;

public class InputTest {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String inString = in.nextLine();
//        System.out.println("Test:" + inString);
        FunctionInterface functionInterface = input -> {
            return input + "1";
        };
        FunctionInterface functionInterface2 = InputTest::getInstance;
        FunctionInterface functionInterface3 = InputTest::getMessage;

        String msg1 = joinStr("你好", functionInterface2);
        String msg2 = joinStr("你好", functionInterface3);

        System.out.println(msg1);
        System.out.println(msg2);
    }

    public static String getInstance(String item) {
        return item + "！世界";
    }

    public static String getMessage(String massage) {
        return "世界," + massage + "!";
    }

    public static String joinStr(String str, FunctionInterface functionTest) {
        return functionTest.getInfo(str);
    }
}