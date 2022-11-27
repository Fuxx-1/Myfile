package ltd.newimg.saletest.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-27 13:46
 */
@Component
public class RedisSaleTest {

    @Autowired
    private RedisUtil redisUtil;

    private AtomicInteger atomicInteger = new AtomicInteger();

    public void test() throws InterruptedException {
        atomicInteger.set(0);
        redisUtil.redisTemplate.opsForValue().set("test", 0);
        System.out.println("[Init]" + redisUtil.getValue("test"));
        System.out.println("[test]" + atomicInteger);
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                int test = redisUtil.incr("test");
                System.out.println(Thread.currentThread() + "" + test + " ");
                // 业务代码
                if (test <= 1000) {
                    add();
                }
            }, "A" + i).start();
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println(redisUtil.getValue("test") + "->" + atomicInteger);
    }

    public void add() {
        System.out.println(atomicInteger.getAndIncrement());
    }
}
