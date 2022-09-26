import com.demo.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Fuxx-1
 * @date 2021年07月23日 14:39
 */
public class MyTest {
    @Test
    public void Test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.toString());
    }
}
