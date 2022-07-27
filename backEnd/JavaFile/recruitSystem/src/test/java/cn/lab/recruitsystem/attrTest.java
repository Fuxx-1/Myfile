package cn.lab.recruitsystem;

import org.junit.jupiter.api.Test;

public class attrTest {
    @Test
    public void Test1() {
        String a = "``kjl`jk`jkjkjkj`;ljion`";
        a = a.replaceAll("[^a-zA-Z]", "");
        System.out.println(a);
    }
}
