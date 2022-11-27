package ltd.newimg.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import ltd.newimg.pojo.Order;
import ltd.newimg.pojo.Product;
import ltd.newimg.service.OrderService;
import ltd.newimg.service.external.ProductService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.lang.annotation.Retention;
import java.util.List;
import java.util.Random;

import static javax.swing.UIManager.get;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-20 23:48
 */
@RestController
@Slf4j
public class OrderController {

//    @Resource
//    private RestTemplate restTemplate;

//    @Resource
//    private DiscoveryClient discoveryClient;
    
    @Resource
    private OrderService orderService;

    @Resource
    private ProductService productService;

    /**
     * 创建订单
     *
     * @param userid 用户id
     * @param pid    商品id
     * @return 订单信息
     */
    @RequestMapping("/order/prod/{userid}/{pid}")
    public Order createOrder(@PathVariable("userid") Integer userid, @PathVariable("pid") Integer pid) {
        Random random = new Random();
        log.info("createOrder->[{}, {}]", userid, pid);
        // 查询商品信息
//        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
//        ServiceInstance serviceInstance = instances.get(random.nextInt(instances.size()));
//        Product product = restTemplate.getForObject(
//                "http://service-product/product/" + pid
//                , Product.class
//        );
        Product product = productService.findProductByPid(pid);
        log.info("findProduct@{}: [{}]", pid, JSON.toJSONString(product));
        // 创建订单
        Order order = orderService.createOrder(new Order(
                null, userid, "test", pid, product.getPname(), product.getPrice(), 1
        ));
        log.info("order@{}: [{}]", order.getOid(), JSON.toJSONString(order));
        // 返回
        return order;
    }
}
