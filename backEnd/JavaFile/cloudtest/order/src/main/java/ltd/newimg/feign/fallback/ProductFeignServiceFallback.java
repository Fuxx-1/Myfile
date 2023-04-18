package ltd.newimg.feign.fallback;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.C;
import ltd.newimg.feign.ProductFeignService;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignServiceFallback implements ProductFeignService {
    @Override
    public String get(Integer id) {
        return "降级中";
    }
}
