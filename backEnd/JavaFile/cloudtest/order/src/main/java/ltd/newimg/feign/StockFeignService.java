package ltd.newimg.feign;

import ltd.newimg.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-service", path = "/stock", configuration = FeignConfig.class)
public interface StockFeignService {

    @RequestMapping("/reduct")
    boolean reduct();

}
