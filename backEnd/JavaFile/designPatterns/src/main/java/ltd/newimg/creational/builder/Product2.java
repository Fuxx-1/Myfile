package ltd.newimg.creational.builder;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 19:21
 */
public class Product2 {
    private final String subProduct1;
    private final String subProduct2;

    private Product2(Builder builder) {
        this.subProduct1 = builder.subProduct1;
        this.subProduct2 = builder.subProduct2;
    }

    public static class Builder {
        private final String subProduct1;
        private String subProduct2;

        public Builder(String subProduct1) {
            this.subProduct1 = subProduct1;
        }

        public Builder subProduct2(String subProduct2) {
            this.subProduct2 = subProduct2;
            return this;
        }

        public Product2 build() {
            return new Product2(this);
        }
    }

    @Override
    public String toString() {
        return "Product2(" +
                "subProduct1=" + subProduct1 + ", " +
                "subProduct2=" + subProduct2 +
                ")";
    }
}
