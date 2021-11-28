import java.io.File;

/**
 * @create: 2021-03-15 21:46
 **/
public class Main {
    static {
        File file = new File(Service.Save_Dir);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        System.out.println(service.Save());
    }
}
