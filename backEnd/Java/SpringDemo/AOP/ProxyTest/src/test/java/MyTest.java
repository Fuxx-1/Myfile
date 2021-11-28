import com.demo.Host;
import com.demo.ProxyInvocationHandlerForDemo;
import com.demo.Rent;
import com.demo2.ProxyInvocationHandler;
import org.junit.Test;
import com.log.service.UserService;
import com.log.service.UserServiceImpl;

public class MyTest {
    @Test
    public void Test() {
        //房东要租房
        Host host = new Host();
        //代理角色，现在没有
        ProxyInvocationHandlerForDemo handler = new ProxyInvocationHandlerForDemo();
        //通过调用程序处理角色来处理我们要调用的接口对象
        handler.setRent(host);
        Rent proxy = (Rent) handler.getProxy();
        proxy.rent();
    }

    @Test
    public void Test2() {
        //真实对象
        UserServiceImpl userService = new UserServiceImpl();
        //代理对象的调用处理程序
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService); //设置要代理的对象
        UserService proxy = (UserService) pih.getProxy(); //动态生成代理类！
        proxy.delete();
    }
}