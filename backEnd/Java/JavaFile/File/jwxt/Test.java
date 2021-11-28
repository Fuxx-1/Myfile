/**
 * @author Fuxx-1
 * @date 2021年09月12日 10:13
 */
public class Test {
    public static void main(String[] args) {
        ConnectJWGL connection = new ConnectJWGL("04202084", "fxx200224");
        try {
            connection.init();
            connection.beginLogin();
            connection.getStudentInformaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
