public class JavaDemo {
    static {
        System.out.println("Test static");
    }
    public static void main(String[] args) {
        new Myclass();
    }
}
class Myclass {
    static {
        System.out.println("MyClass static");
    }
    public Myclass() {
        System.out.println("myclass constructor");
    }
}