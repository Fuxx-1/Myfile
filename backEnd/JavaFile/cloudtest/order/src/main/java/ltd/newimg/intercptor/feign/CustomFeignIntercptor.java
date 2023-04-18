package ltd.newimg.intercptor.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class CustomFeignIntercptor implements RequestInterceptor {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // TODO
        requestTemplate.header("xxx", "xxx");
        requestTemplate.query("id", "111");
        requestTemplate.uri("/9");
        logger.info("feign拦截器！");
    }
}
