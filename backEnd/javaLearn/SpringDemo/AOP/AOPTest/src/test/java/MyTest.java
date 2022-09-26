import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.service.UserService;

/**
 * @author Fuxx-1
 * @date 2021年07月24日 10:51
 */
public class MyTest {
    @Test
    public void Test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
