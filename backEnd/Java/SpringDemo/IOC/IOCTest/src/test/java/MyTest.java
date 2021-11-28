import com.demo.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @create: 2021-07-23 10:07
 **/
public class MyTest {
    @Test
    public void Test(){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //获取ApplicationContext: 拿到Spring的容器
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        userServiceImpl.getUser();

//        UserService userService = new UserServiceImpl();
//        //用户实际调用的是业务层，Dao层他们不需要接触！
//        userService.setUserDao(new UserDaoMySQLImpl());
//        userService.getUser();
    }
}
