package ltd.newimg.structural.adapter;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 15:13
 */
public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        throw new RuntimeException("TypeNotSupport");
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file -> "+ fileName);
    }
}
