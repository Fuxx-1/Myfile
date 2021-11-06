package java;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Fuxx-1
 * @date 2021年08月03日 16:03
 */
public class test {
    @Test
    public void test1() {
        String[] num = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        String[] color = {"红桃", "黑桃", "梅花", "方片"};
        ArrayList<String> poker = new ArrayList<>();

        for (String s : color) {
            for (String s1 : num) {
                poker.add(s.concat(s1));
            }
        }
        Iterator<String> it = poker.iterator();
        while (it.hasNext()) {
            System.out.println(it.toString());
            it.next();
        }

    }
}
