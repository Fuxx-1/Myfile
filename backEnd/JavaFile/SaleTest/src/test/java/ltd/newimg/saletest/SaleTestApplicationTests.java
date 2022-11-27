package ltd.newimg.saletest;

import ltd.newimg.saletest.Util.RedisSaleTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SaleTestApplicationTests {

    @Autowired
    RedisSaleTest redisSaleTest;

    @Test
    void contextLoads() throws InterruptedException {
        redisSaleTest.test();
    }

}
