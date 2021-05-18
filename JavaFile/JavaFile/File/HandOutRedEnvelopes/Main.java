import java.lang.reflect.Array;
import java.util.ArrayList;
/*
该程序用于发普通红包
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        GroupLeader leader = new GroupLeader("leader", 100);
        Member m1 = new Member("m1", 10);
        Member m2 = new Member("m2", 20);
        Member m3 = new Member("m3", 30);
        leader.show();
        m1.show();
        m2.show();
        m3.show();
        a = leader.send(3, 100);
        m1.receive(a);
        m2.receive(a);
        m3.receive(a);
        System.out.println("发红包完成了！");
        leader.show();
        m1.show();
        m2.show();
        m3.show();
    }
}
