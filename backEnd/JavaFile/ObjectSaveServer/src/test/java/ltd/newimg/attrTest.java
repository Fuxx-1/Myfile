package ltd.newimg;

import ltd.newimg.util.NanoIdUtil;
import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author Fuxx-1@Github
 * @Description
 * @date 2022/07/21 12:04
 */
public class attrTest {
    @Test
    public void Test1() {
        System.out.println("0.part".matches("[0-9]{1,}.part"));
        System.out.println(new File("." + File.separator + "bigFile" + File.separator + "6ff38faf179b111d041fd37fd4fdc6f3" + File.separator + "e39d6d226fe49196e6ae58d75f0e717d3cf1844b" + File.separator).length());
    }

    @Test
    public void Test2() throws ArrayIndexOutOfBoundsException {
        char[] test = "abc".toCharArray();
        try {
            for (int i = 0; i < test.length; i++) {
                System.out.println(test[i + 1]);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("test");
    }
    @Test
    public void test3() {
        System.out.println(NanoIdUtil.randomNanoId());
    }
}
