package ltd.newimg;

import ltd.newimg.util.VideoUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Eleun
 * @Description
 * @create 2022-07-28 12:13
 */
public class VideoTest {
    @Test
    public void test1() {
        VideoUtil.videoToVideo("D:" + File.separator + "Programing" + File.separator + "Myfile" + File.separator + "backEnd" + File.separator + "JavaFile" + File.separator + "ObjectSaveServer" + File.separator + "bigFile" + File.separator + "6ff38faf179b111d041fd37fd4fdc6f3" + File.separator + "e39d6d226fe49196e6ae58d75f0e717d3cf1844b" + File.separator + "XUPT——ACM2021寒假集训 - 王乐乐嘛 - 哔哩哔哩直播，二次元弹幕直播平台.flv"
                , "D:" + File.separator + "Programing" + File.separator + "Myfile" + File.separator + "backEnd" + File.separator + "JavaFile" + File.separator + "ObjectSaveServer" + File.separator + "bigFile" + File.separator + "6ff38faf179b111d041fd37fd4fdc6f3" + File.separator + "e39d6d226fe49196e6ae58d75f0e717d3cf1844b" + File.separator + "test.mp4");
    }

    @Test
    public void test2() {
        try {
            VideoUtil.mp4tom3u8("D:" + File.separator + "Programing" + File.separator + "Myfile" + File.separator + "backEnd" + File.separator + "JavaFile" + File.separator + "ObjectSaveServer" + File.separator + "bigFile" + File.separator + "6ff38faf179b111d041fd37fd4fdc6f3" + File.separator + "e39d6d226fe49196e6ae58d75f0e717d3cf1844b" + File.separator + "test.mp4"
                    , "D:" + File.separator + "Programing" + File.separator + "Myfile" + File.separator + "backEnd" + File.separator + "JavaFile" + File.separator + "ObjectSaveServer" + File.separator + "bigFile" + File.separator + "6ff38faf179b111d041fd37fd4fdc6f3" + File.separator + "e39d6d226fe49196e6ae58d75f0e717d3cf1844b" + File.separator + "test.m3u8"
                    , "D:" + File.separator + "Programing" + File.separator + "Myfile" + File.separator + "backEnd" + File.separator + "JavaFile" + File.separator + "ObjectSaveServer" + File.separator + "bigFile" + File.separator + "6ff38faf179b111d041fd37fd4fdc6f3" + File.separator + "e39d6d226fe49196e6ae58d75f0e717d3cf1844b" + File.separator + "video");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
