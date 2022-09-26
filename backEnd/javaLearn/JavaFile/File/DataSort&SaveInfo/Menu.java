/**
 * @create: 2021-03-21 15:38
 **/
public class Menu {
    public Menu() {
        this.choose();
    }
    public void choose() {
        this.show();
        String choose = InputUtil.getString("请进行选择");
        switch (choose) {
            case "1":{  //接收输入数据
                String str = InputUtil.getString("请输入要追加的数据：");
                Service studentService = new Service();
                studentService.append(str);  //追加数据
                choose();//重复出现
            }
            case "2":{  //显示数据
                Service studentService = new Service();
                System.out.println(Array.toString(studentService.getData()));
                choose();//重复出现
            }
            case "0":{
                System.out.println("下次再见，拜拜！");
                System.exit(1);
            }
            default:{
                System.out.println("您输入了非法的选项，无法进行处理，歉意确认后再次执行程序！");
                choose();
            }
        }
    }
    public void show() {
        System.out.println("【1】追加字符串数据\n");
        System.out.println("【2】显示所有的学生数据\n");
        System.out.println("【0】结束程序执行。");
        System.out.println("\n\n\n");
    }
}
