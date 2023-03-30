package ltd.newimg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/add")
    public boolean add() {
        System.out.println("下单成功");
        Boolean reduct = restTemplate.getForObject("http://stock-service:8111/stock/reduct", boolean.class);
        System.out.println(reduct);
        return true;
    }
}
