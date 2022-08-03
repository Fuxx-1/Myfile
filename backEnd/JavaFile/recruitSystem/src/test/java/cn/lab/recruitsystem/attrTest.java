package cn.lab.recruitsystem;

import org.junit.jupiter.api.Test;

public class attrTest {
    @Test
    public void Test1() {
        String a = "``kjl`jk`jkjkjkj`;ljion`";
        a = a.replaceAll("[^a-zA-Z]", "");
        System.out.println(a);
    }

    @Test
    public void Test2() {
        StringBuffer sb = new StringBuffer("第三方");
        sb.setCharAt(1, '*');
        System.out.println(sb.toString());
    }
}
