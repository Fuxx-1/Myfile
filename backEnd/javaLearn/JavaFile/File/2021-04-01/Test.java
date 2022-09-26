/**
 * @create: 2021-04-01 20:25
 **/
class Fun1 {
    private int a;
    private int Info = 123;

    public Fun1(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }
}

class Fun2 extends Fun1 {
    private int b;
    public Fun2(int a, int b) {
        super(a);
        this.b = b;
    }

    @Override
    public String toString() {
        return "Fun2{" +
                "b=" + b +
                "a=" + super.getA() +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        String str = "sdjkfksdjf";
        System.out.println(str.hashCode());
        Fun2 a = new Fun2(1, 2);
        System.out.println(a.toString());
    }
}
