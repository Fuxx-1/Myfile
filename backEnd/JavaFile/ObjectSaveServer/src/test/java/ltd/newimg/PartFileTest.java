package ltd.newimg;

import ltd.newimg.model.dto.PartFileDTO;
import ltd.newimg.model.dto.PartFileInfoDTO;
import ltd.newimg.service.PartFileService;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

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

    PartFileInfoDTO partFileInfoDTO = new PartFileInfoDTO(MD5, SHA1, "." + staticFile.getName().split("\\.")[staticFile.getName().split("\\.").length - 1], (int) Math.ceil(fileSize / (float) chunkSize), fileSize);

    @Test
    public void testInfo() {
        System.out.println(partFileInfoDTO);
        System.out.println(partFileService.initPartFileUpload(partFileInfoDTO).toJSONString());
    }

    @Test
    public void partFileUpload() {
        long size = staticFile.length();
        int count = (int) (size / (float) chunkSize);
        for (int i = 0; i <= count; i++) {
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
        try {
            for (int i = 0; i <= count; i++) {
                File file = new File("./" + i + ".file_temp");
                MultipartFile multipartFile = new MockMultipartFile(file.getName(), Files.newInputStream(file.toPath()));
                System.out.println(partFileService.partFileUpload(new PartFileDTO(i, count + 1, multipartFile, DigestUtils.md5Hex(Files.newInputStream(file.toPath())), MD5, SHA1)).toJSONString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void queryFileUploadCondition() {
        System.out.println(partFileService.queryFileUploadCondition(partFileInfoDTO).toJSONString());
    }

    @Test
    public void mergeFile() {
        System.out.println(partFileService.mergeFile(partFileInfoDTO).toJSONString());
    }

    @Test
    public void cancelFile() {
        System.out.println(partFileService.cancelFile(partFileInfoDTO).toJSONString());
    }
}
