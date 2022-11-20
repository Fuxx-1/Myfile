package ltd.newimg.service;

import ltd.spring.BeanNameAware;
import ltd.spring.InitializingBean;
import ltd.spring.anno.AutoWired;
import ltd.spring.anno.Component;
import ltd.spring.anno.Scope;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-16 10:25
 */
@Component("userService")
@Scope("prototype")
public class UserService implements BeanNameAware, InitializingBean {
    @AutoWired

    private OrderService orderService;

    private String beanName;


    public void testOrderService() {
        System.out.println(orderService);
    }

    public void testBeanName() {
        System.out.println(beanName);
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init");
    }
}
