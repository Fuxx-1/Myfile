package ltd.newimg.structural.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Eleun
 * @Description
 * @create 2022-11-26 15:16
 */
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {

        //播放 mp3 音乐文件的内置支持
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file. Name: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc")
                || audioType.equalsIgnoreCase("mp4")) {
            //mediaAdapter 提供了播放其他文件格式的支持
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            throw new RuntimeException("TypeNotSupport");
        }
    }
}
