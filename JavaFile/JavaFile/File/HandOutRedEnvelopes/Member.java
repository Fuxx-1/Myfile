import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member(String name, int balance) {
        super(name, balance);
    }

    public void receive(ArrayList<Integer> list) {
        int dex = new Random().nextInt(list.size());
        super.setBalance(super.getBalance() + list.get(dex));
        list.remove(dex);
    }
}
