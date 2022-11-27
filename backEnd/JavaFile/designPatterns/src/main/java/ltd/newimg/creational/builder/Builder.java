package ltd.newimg.creational.builder;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 18:50
 */
public interface Builder {
    boolean setSubProduct1();

    boolean setSubProduct2();

    boolean setSubProduct3();

    Product getProduct();
}
