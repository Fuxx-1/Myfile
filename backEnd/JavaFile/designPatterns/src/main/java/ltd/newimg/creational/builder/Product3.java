package ltd.newimg.creational.builder;

import lombok.Builder;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-25 19:21
 */
@Builder
public class Product3 {
    private final String subProduct1;
    private final String subProduct2;

    @Override
    public String toString() {
        return "Product2(" +
                "subProduct1=" + subProduct1 + ", " +
                "subProduct2=" + subProduct2 +
                ")";
    }
}
