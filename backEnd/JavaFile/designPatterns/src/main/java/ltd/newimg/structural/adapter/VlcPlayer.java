package ltd.newimg.structural.adapter;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 15:12
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file -> "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        throw new RuntimeException("TypeNotSupport");
    }
}
