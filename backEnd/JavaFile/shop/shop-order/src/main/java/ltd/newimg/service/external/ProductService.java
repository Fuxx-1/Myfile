package ltd.newimg.service.external;

import com.alibaba.fastjson.JSON;
import ltd.newimg.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-27 20:13
 */
@FeignClient("service-product")
public interface ProductService {

    @RequestMapping("/product/{pid}")
    Product findProductByPid(@PathVariable("pid") Integer pid);

}
