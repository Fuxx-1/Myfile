import com.demo.pojo.Person;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Fuxx-1
 * @date 2021年07月23日 16:37
 */
public class MyTest {
    @Test
    public void Test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) context.getBean("person", Person.class);
        System.out.println(person.toString());
    }

    @Test
    public void Test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        Person person = (Person) context.getBean("person", Person.class);
        System.out.println(person.toString());
    }
}
