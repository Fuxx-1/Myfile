import java.util.ArrayList;

public class GroupLeader extends User {

    public GroupLeader(String name, int balance) {
        super(name, balance);
    }
    public ArrayList<Integer> send(int num, int sum) {
        ArrayList<Integer> a = new ArrayList<>();
        if (sum < super.getBalance()) {
            System.out.println("余额不足！");
            return a;
        }
        super.setBalance(super.getBalance() - sum);
        int remainder = sum % num;
        int every = sum / num;
        for (int i = 0; i < num; i++) {
            if (i == num - 1) {
                every = every + remainder;
            }
            a.add(every);
        }
        return a;
    }
}
