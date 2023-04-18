package ltd.newimg.feign;

import feign.Param;
import feign.RequestLine;
import ltd.newimg.feign.fallback.ProductFeignServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-service", path = "/product", fallback = ProductFeignServiceFallback.class)
public interface ProductFeignService {

    @RequestLine("GET /{id}")
    String get(@Param("id") Integer id);

//    @RequestMapping("/{id}")
//    String get(@PathVariable("id") Integer id);
}
