public class C extends A {
    static {
        System.out.println("C的静态代码块");
    }

    {
        System.out.println("C构造代码块");
    }

    C() {
        System.out.println("C的构造方法");
    }
}