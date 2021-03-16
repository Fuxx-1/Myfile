import java.util.Arrays;

/**
 * @create: 2021-03-16 21:18
 **/
public class Menu {
    private Server Service;

    public Menu() {
        this.Service = new Server();
        this.choose();
    }

    public void choose() {
        this.show();
        String choose = InputUtil.getString("请进行选择：");
        switch (choose) {
            case "1": {
                String str = InputUtil.getString("请输入字符串数据：");
                this.Service.append(str);
                choose();
            }
            case "2": {
                String str = InputUtil.getString("请输入字符串数据：");
                this.Service.append(str);
                String[] Result = this.Service.Reverse();
                System.out.println(Arrays.toString(Result));
                choose();
            }
            case "0": {
                System.out.println("下次再见！");
                System.exit(1);
            }
            default:{
                System.out.println("您输入了非法的选项！");
                choose();
            }
        }
    }

    public void show() {
        System.out.println("\n【0】退出");
        System.out.println("【1】追加字符串数据");
        System.out.println("【2】逆序显示所有字符串数据");
    }
}
