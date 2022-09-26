import java.util.ArrayList;

/**
 * @author Fuxx-1
 * @date 2021年08月03日 16:25
 */
public class Test {
    public static void main(String[] args) {
        String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] color = {"红桃", "黑桃", "梅花", "方片"};
        ArrayList<String> poker = new ArrayList<>();

        for (String s : color) {
            for (String s1 : num) {
                poker.add(s.concat(s1));
            }
        }
        for (String s : poker) {
            System.out.println(s);
        }
    }
}
