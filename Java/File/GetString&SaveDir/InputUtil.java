import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @create: 2021-03-15 21:56
 **/
public class InputUtil {
    public static final BufferedReader Input = new BufferedReader(new InputStreamReader(System.in));

    public static String getString(String prompt) {
        String str = null;
        boolean flag = true;
        while (flag) {
            System.out.println(prompt);
            try {
                str = Input.readLine();
                if (!"".equals(str)) {
                    flag = false;
                } else {
                    System.out.println("输入的内容不允许为空！");
                }
            } catch (IOException e) {
                System.out.println("输入的内容不允许为空！");
            }
        }
        return str;
    }
}
