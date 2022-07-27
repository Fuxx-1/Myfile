package ltd.newimg.config;

/**
 * @program: PetHospitalInformationManage
 * @description:
 * @author: Fuxx-1
 * @create: 2022-03-27 22:37
 **/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器注入
 * @author Fuxx-1@Github
 * @Description
 * @date 2022/07/21 13:58
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private URLInterceptor urlInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(urlInterceptor);
    }
}

