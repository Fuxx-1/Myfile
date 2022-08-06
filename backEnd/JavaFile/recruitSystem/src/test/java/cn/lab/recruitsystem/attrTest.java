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
        System.out.println("12345678".substring(2, 8));
    }

    @Test
    public void test3(){
        System.out.println(System.getenv("WECHAT_APP_SECRET"));
    }


}
