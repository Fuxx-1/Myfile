package ltd.newimg.config;

import feign.Contract;
import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

//    @Bean
//    public Contract feignContract() {
//        return new Contract.Default();
//    }

//    @Bean
//    public Request.Options options() {
//        return new Request.Options(5000, 10000);
//    }

//    @Bean
//    public FeignAuthRequestIntercptor feignAuthRequestIntercptor() {
//        return new FeignAuthRequestIntercptor();
//    }
}
