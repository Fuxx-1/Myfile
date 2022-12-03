package ltd.newimg.structural.proxy;

import javax.xml.transform.Source;
import java.sql.SQLOutput;

/**
 * @author Eleun
 * @Description
 * @create 2022-12-02 19:53
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("[Display]" + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("[Loading]" + fileName);
    }
}
