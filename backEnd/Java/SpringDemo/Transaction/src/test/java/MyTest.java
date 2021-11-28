import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Fuxx-1
 * @date 2021年07月25日 23:38
 */
public class MyTest {
    @Test
    public void TestForSelectUser() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        for (User user : userMapper.selectUser()) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void TestForAddUser() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        System.out.println(userMapper.deleteUser(4));
    }
}
