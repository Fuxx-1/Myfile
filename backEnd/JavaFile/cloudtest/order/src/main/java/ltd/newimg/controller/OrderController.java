package ltd.newimg.controller;

import ltd.newimg.feign.ProductFeignService;
import ltd.newimg.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

//    @Autowired
//    RestTemplate restTemplate;

    @Resource
    StockFeignService stockFeignService;

    @Resource
    ProductFeignService productFeignService;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");

//        Boolean reduct = restTemplate.getForObject("http://stock-service:8111/stock/reduct", boolean.class);
        boolean reduct = stockFeignService.reduct();
        System.out.println(reduct);
        String p = productFeignService.get(1);
        System.out.println(p);
        return reduct + "\n" + p;
    }
}
