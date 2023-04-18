package ltd.newimg.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("product")
public class ProductController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/{id}")
    public String get(@PathVariable Integer id) throws InterruptedException {
//        Thread.sleep(6000);
        if (new Random().nextInt(2) == 1) {
            throw new RuntimeException("RandomException");
        }
        System.out.println("查询商品" + id);
        return "port:" + port + " | 查询商品:" + id;
    }
}
