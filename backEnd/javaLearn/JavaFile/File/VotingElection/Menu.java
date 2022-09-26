/**
 * @create: 2021-03-21 11:19
 **/


public class Menu {
    private Service Service;

    public Menu() {
        this.Service = new Service();
        this.vote();
    }

    public void vote() {   //投票处理
        Student[] stu = this.Service.getData();
        for (Student temp : stu) {
            System.out.println(temp.getSid() + ":" + temp.getName() + "【"
                    + temp.getVote() + "】");
        }
        int num = 10;
        while (num != 0) {   //循环投票
            num = InputUtil.getInt("请输入班长候选人代号（数字0结束）：");
            if (num != 0) {
                if (!this.Service.inc(num)) {
                    System.out.println("此选票无效，请输入正确的候选人代号！");
                }
            }
        }
        System.out.println("投票最终结果：");
        stu = this.Service.result();
        System.out.println(stu[0].getName() + "同学，以" + stu[0].getVote() + "票数当选班长。");
        for (Student temp : stu) {
            System.out.println(temp.getSid() + ":" + temp.getName() + "【"
                    + temp.getVote() + "】");
        }
    }
}