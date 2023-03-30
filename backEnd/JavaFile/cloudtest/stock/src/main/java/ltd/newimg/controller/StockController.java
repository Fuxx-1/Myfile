package ltd.newimg.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock")
public class StockController {
    @RequestMapping("/reduct")
    public boolean reduct() {
        System.out.println("扣减库存");
        return true;
    }
}
