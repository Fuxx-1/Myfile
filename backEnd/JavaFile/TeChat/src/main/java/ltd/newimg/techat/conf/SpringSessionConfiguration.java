package ltd.newimg.techat.conf;

import org.apache.tomcat.util.http.Rfc6265CookieProcessor;
import org.apache.tomcat.util.http.SameSiteCookies;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringSessionConfiguration {

    // @Bean
    // public CookieSerializer httpSessionIdResolver() {
    //     DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
    //     cookieSerializer.setCookieName("token");
    //     cookieSerializer.setUseHttpOnlyCookie(true);
    //     cookieSerializer.setSameSite(null);
    //     cookieSerializer.setUseSecureCookie(true);
    //     return cookieSerializer;
    // }

    @Bean
    public TomcatContextCustomizer sameSiteCookiesConfig() {
        return context -> {
            final Rfc6265CookieProcessor cookieProcessor = new Rfc6265CookieProcessor();
            cookieProcessor.setSameSiteCookies(SameSiteCookies.NONE.getValue());
            context.setCookieProcessor(cookieProcessor);
        };
    }

}