package ltd.newimg.creational.builder;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 18:51
 */
public class ConcurrentBuilder1 implements Builder{

    private Product product;

    public ConcurrentBuilder1() {
        this.product = new Product();
    }

    @Override
    public boolean setSubProduct1() {
        this.product.setSubProduct1("C1S1");
        return true;
    }

    @Override
    public boolean setSubProduct2() {
        this.product.setSubProduct2("C1S2");
        return true;
    }

    @Override
    public boolean setSubProduct3() {
        this.product.setSubProduct3("C1S3");
        return true;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }
}
