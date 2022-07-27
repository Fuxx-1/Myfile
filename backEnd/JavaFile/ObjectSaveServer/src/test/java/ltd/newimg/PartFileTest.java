package ltd.newimg;

import ltd.newimg.model.dto.PartFileInfoDTO;
import ltd.newimg.service.PartFileService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author Eleun
 * @Description
 * @create 2022-07-27 11:11
 */
@SpringBootTest
public class PartFileTest {

    @Resource
    PartFileService partFileService;

    File staticFile = new File("./Test.txt");

    String SHA1, MD5;

    Integer chunkSize = 1 * 1024;

    Long fileSize = staticFile.length();

    {
        try {
            SHA1 = DigestUtils.sha1Hex(new FileInputStream(staticFile));
            MD5 = DigestUtils.md5Hex(new FileInputStream(staticFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    PartFileInfoDTO partFileInfoDTO = new PartFileInfoDTO(MD5, SHA1, ".txt", (int) Math.ceil(fileSize / (float) chunkSize), fileSize);

    @Test
    public void testInfo() {
        System.out.println(partFileService.initPartFileUpload(partFileInfoDTO).toJSONString());
    }

    @Test
    public void partFileUpload() {
        long size = staticFile.length();
        int count = (int) size / (float) chunkSize;
        for (int i = 0; i < count; i++) {
            String filePath = "./" + i + ".file_temp";
            try {
                FileInputStream in = new FileInputStream(staticFile);
                FileOutputStream out = null;
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = null;
                out = new FileOutputStream(new File(filePath));
                outChannel = out.getChannel();
                if (i != count) {
                    inChannel.transferTo(chunkSize * i, chunkSize, outChannel);
                } else {
                    inChannel.transferTo(chunkSize * i, size - chunkSize * count, outChannel);
                }
            } catch (Exception e) {

            }
        }
        for (int i = 0; i < count; i++) {
            
        }
    }

    @Test
    public void queryFileUploadCondition() {
        System.out.println(partFileService.queryFileUploadCondition(partFileInfoDTO).toJSONString());
    }

    @Test
    public void mergeFile() {

    }

    @Test
    public void cancelFile() {

    }
}
