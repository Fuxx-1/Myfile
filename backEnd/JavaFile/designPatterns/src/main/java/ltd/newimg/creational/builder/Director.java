package ltd.newimg.creational.builder;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 18:51
 */
public class Director {
    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void createProduct() {
        builder.setSubProduct1();
        builder.setSubProduct2();
        builder.setSubProduct3();
    }

    public Product getProduct() {
        return builder.getProduct();
    }

}
