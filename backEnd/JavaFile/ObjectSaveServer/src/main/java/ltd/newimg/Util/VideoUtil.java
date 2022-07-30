package ltd.newimg.util;

import ws.schild.jave.Encoder;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.encode.AudioAttributes;
import ws.schild.jave.encode.EncodingAttributes;
import ws.schild.jave.encode.VideoAttributes;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Eleun
 * @Description 视频格式转换
 * @create 2022-07-28 12:57
 */
public class VideoUtil {

    private static final int CODE_SUCCESS = 0;
    private static final int CODE_FAIL = 1;
    private static String cmd_mp4_2_ts_1 = " -y -i ";
    private static String cmd_mp4_2_ts_2 = " -vcodec copy -acodec copy -vbsf h264_mp4toannexb ";
    private static String cmd_ts_split_1 = " -i ";
    private static String cmd_ts_split_2 = " -c copy -map 0 -f segment -segment_list ";
    private static String cmd_ts_split_3 = " -segment_time 15 ";
    private static String cmd_ts_split_4 = "_%3d.ts";


    /**
     * 视频转码
     *
     * @param videoSource 视频源地址
     * @param videoTarget 输出地址
     * @return 是否成功
     */
    public static boolean videoToVideo(String videoSource, String videoTarget) {

        long start = System.currentTimeMillis(); // 开始计时

        File source = new File(videoSource);
        File target = new File(videoTarget);

        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("aac").setBitRate(236000 / 2).setChannels(2).setSamplingRate(8000);

        VideoAttributes video = new VideoAttributes();
        video.setCodec("h264").setBitRate(1000000).setFrameRate(25).setQuality(4);
//        video.setSize(new VideoSize(720, 480));

        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setOutputFormat("mp4").setAudioAttributes(audio).setVideoAttributes(video);

        Encoder encoder = new Encoder();

        try {
            encoder.encode(new MultimediaObject(source), target, attrs);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(encoder.getUnhandledMessages());
            return false;
        } finally {
            long end = System.currentTimeMillis(); // 结束计时
            System.out.println("总耗时：" + (end - start) + "ms"); // 输出总耗时
        }
    }


    /**
     * 第一步：视频整体转码ts
     * 第二步：ts 文件切片
     */
    public static void mp4tom3u8(String mp4FileDir, String m3u8FileDir, String tsFileDir) throws IOException {
        String tempTs = "./temp/temp.ts";
        new File(tempTs).getParentFile().mkdirs();
        new File(tempTs).createNewFile();
        new File(m3u8FileDir).createNewFile();
        new File(tsFileDir).createNewFile();
        Integer code1 = cmdExecut(cmd_mp4_2_ts_1 + mp4FileDir + cmd_mp4_2_ts_2 + tempTs); // 第一步：视频整体转码ts
        Integer code2 = cmdExecut(cmd_ts_split_1 + tempTs + cmd_ts_split_2 + m3u8FileDir + cmd_ts_split_3 + tsFileDir + cmd_ts_split_4); // 第二步：ts 文件切片,成功！

    }

    /**
     * @throws
     * @Description: (执行ffmpeg自定义命令)
     * @param: @param cmdStr
     * @param: @return
     * @return: Integer
     */
    public static Integer cmdExecut(String cmdStr) {
        //code=0表示正常
        Integer code = null;
        FfmpegCmd ffmpegCmd = new FfmpegCmd();
        /**
         * 错误流
         */
        InputStream errorStream = null;
        try {
            //destroyOnRuntimeShutdown表示是否立即关闭Runtime
            //如果ffmpeg命令需要长时间执行，destroyOnRuntimeShutdown = false

            //openIOStreams表示是不是需要打开输入输出流:
            //	       inputStream = processWrapper.getInputStream();
            //	       outputStream = processWrapper.getOutputStream();
            //	       errorStream = processWrapper.getErrorStream();
            ffmpegCmd.execute(false, true, cmdStr);
            errorStream = ffmpegCmd.getErrorStream();

            //打印过程
            int len = 0;
            while ((len = errorStream.read()) != -1) {
                System.out.print((char) len);
            }

            //code=0表示正常
            code = ffmpegCmd.getProcessExitCode();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            ffmpegCmd.close();
        }
        //返回
        return code;
    }

}
