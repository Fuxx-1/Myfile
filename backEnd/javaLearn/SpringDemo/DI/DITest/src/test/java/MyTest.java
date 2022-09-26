import com.demo.pojo.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Fuxx-1
 * @date 2021年07月23日 15:24
 */
public class MyTest {
    @Test
    public void Test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
        /*
            Student{
                name='Fuxx-1',
                address=Address{
                    address='陕西省西安市长安区郭杜街道西安邮电大学'
                },
                books=[《红楼梦》, 《西游记》, 《水浒传》, 《三国演义》],
                hobbys=[听歌, 看电影, 敲代码],
                card={
                    身份证=123,
                    银行卡=234
                },
                games=[LOL, COC, BOB],
                wife='null',
                info={
                    学号=345,
                    性别=男
                }
            }
         */
    }
}
