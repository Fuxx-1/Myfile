/**
 * @create: 2021-03-21 11:30
 **/
public class Test {
    private Service userService = new Service();

    public Test(Service userService) {
        this.userService = userService;
    }

    public Test() {
    }

    public boolean login(String name, String password) {
        while (!this.isExit()) {  //不进行退出
            String inputData = InputUtil.getString("请输入登录信息：");
            if (inputData.contains("/")) {  //输入了用户名和密码
                String[] temp = inputData.split("/");  //数据拆分
                if (this.userService.login(temp[0], temp[1])) {  //登录认证
                    return true;  //循环结束了
                } else {
                    System.out.println("登录失败，错误的用户名或密码！");
                }
            } else {  //现在只有用户名
                String pwd = InputUtil.getString("请输入密码：");
                if (this.userService.login(inputData, pwd)) {  //登录认证
                    return true;  //循环结束了
                } else {
                    System.out.println("登录失败，错误的用户名或密码！");
                }
            }
        }
        return false;
    }

    public boolean isExit() {
        return this.userService.isExit();
    }
}
