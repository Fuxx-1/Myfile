package ltd.newimg.creational.builder;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 19:08
 */
public class Main {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        Director director = new Director();
        director.setBuilder(new ConcurrentBuilder1());
        director.createProduct();
        System.out.println(director.getProduct());
        director.setBuilder(new ConcurrentBuilder2());
        director.createProduct();
        System.out.println(director.getProduct());
    }

    public static void test2() {
        Product2 product2 = new Product2.Builder("initS1")
                .subProduct2("S2")
                .build();
        System.out.println(product2.toString());
    }

    public static void test3() {
        Product3 product3 = Product3.builder()
                .subProduct1("initS1")
                .subProduct2("S2")
                .build();
        System.out.println(product3);
    }
}
