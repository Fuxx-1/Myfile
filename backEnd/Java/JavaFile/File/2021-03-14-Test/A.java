public class A {
    static {
        System.out.println("A静态代码块");
    }

    {
        System.out.println("A构造代码块");
    }

    A() {
        System.out.println("A构造方法");
    }

    public static void main(String[] args) {
        C c1 = new C();
    }
}

