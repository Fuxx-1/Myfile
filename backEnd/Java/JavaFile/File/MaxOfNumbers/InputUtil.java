import java.util.Scanner;

public class InputUtil {

    private InputUtil() {
    }

    /**
     * 实现键盘接收数字的操作
     *
     * @param prompt 提示信息
     * @return 一个可以使用的数字
     */
    public static int getInt(String prompt) {
        int num = 0;
        boolean flag = true;
        while (flag) {
            Scanner Input = new Scanner(System.in);
            System.out.println(prompt); //打印提示信息
            if (Input.hasNext("\\d+")) {
                num = Integer.parseInt(Input.next());
                flag = false;
            } else {
                System.out.println("输入的不是数字！");
            }
        }
        return num;
    }
}
