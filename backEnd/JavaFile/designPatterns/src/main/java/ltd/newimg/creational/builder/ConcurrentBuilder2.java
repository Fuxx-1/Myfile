package ltd.newimg.creational.builder;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 18:51
 */
public class ConcurrentBuilder2 implements Builder{

    private Product product;

    public ConcurrentBuilder2() {
        this.product = new Product();
    }

    @Override
    public boolean setSubProduct1() {
        this.product.setSubProduct1("C2S1");
        return true;
    }

    @Override
    public boolean setSubProduct2() {
        this.product.setSubProduct2("C2S2");
        return true;
    }

    @Override
    public boolean setSubProduct3() {
        this.product.setSubProduct3("C2S3");
        return true;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }
}
