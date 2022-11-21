package ltd.newimg.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import ltd.newimg.pojo.Product;
import ltd.newimg.service.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-20 23:48
 */
@RestController
@Slf4j
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * 根据 pid 查询商品信息
     * @param pid 商品pid
     * @return 商品信息
     */
    @RequestMapping("/product/{pid}")
    public Product findProductByPid(@PathVariable("pid") Integer pid) {
        log.info("findProductByPid->{}", pid);
        Product product = productService.findProductByPid(pid);
        log.info("Product@{}: [{}]", pid, JSON.toJSONString(product));
        return product;
    }
}
