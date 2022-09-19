package cn.lab.recruitsystem;

import cn.lab.recruitsystem.Util.NanoIdUtil;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

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

    @Test
    public void test4() throws InterruptedException {
        System.out.println(NanoIdUtil.randomNanoId());
        System.out.println(System.currentTimeMillis());
        ConcurrentHashMap keyMap = new ConcurrentHashMap<String, Long>(5);
        keyMap.put(NanoIdUtil.randomNanoId(), System.currentTimeMillis());
        keyMap.put(NanoIdUtil.randomNanoId(), System.currentTimeMillis());
        keyMap.put(NanoIdUtil.randomNanoId(), System.currentTimeMillis());
        keyMap.put(NanoIdUtil.randomNanoId(), System.currentTimeMillis());
        keyMap.put(NanoIdUtil.randomNanoId(), System.currentTimeMillis());
        for (int i = 0; i < 40; i++) {
            System.out.println("sleep第" + i + "秒");
            TimeUnit.SECONDS.sleep(1);
        }
       keyMap.forEach((key, value) -> {
            System.out.println(key + ":" + (System.currentTimeMillis() - (Long) value) / 1000);
            if (System.currentTimeMillis() - (Long) value > 30 * 1000) {
                keyMap.remove(key);
            }
        });
        keyMap.put(NanoIdUtil.randomNanoId(), System.currentTimeMillis());
        keyMap.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
    }
}
