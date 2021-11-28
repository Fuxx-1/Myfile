import com.demo.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Fuxx-1
 * @date 2021年07月23日 15:53
 */
public class MyTest {
    @Test
    public void TestForC() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("user2");
        System.out.println(user.toString());
    }

    @Test
    public void TestForP() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) context.getBean("user");
        System.out.println(user.toString());
    }
}
