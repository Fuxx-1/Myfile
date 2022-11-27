package ltd.newimg.creational.prototype;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 14:56
 */
public abstract class Shape implements Cloneable {

    @Getter
    @Setter
    private String id;
    @Getter
    protected String type;

    abstract void draw();

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
