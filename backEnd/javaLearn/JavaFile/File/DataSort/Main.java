import java.util.Arrays;

/**
 * @create: 2021-03-16 22:22
 **/
public class Main {
    public static void main(String[] args) {
        Service service = new Service(InputUtil.getString("请输入数据信息："));
        System.out.println(Arrays.toString(service.getData()));
    }
}
