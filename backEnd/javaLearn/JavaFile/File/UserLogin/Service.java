/**
 * @create: 2021-03-21 11:29
 **/
public class Service {
    private int count = 0;   //作为登录统计

    public Service() {
    }

    public boolean isExit() {
        return this.count >= 3;  //执行登录退出的条件
    }
    public boolean login(String name, String password) {
        this.count ++;
        return "a".equals(name) && "12345".equals(password);
    }
}
