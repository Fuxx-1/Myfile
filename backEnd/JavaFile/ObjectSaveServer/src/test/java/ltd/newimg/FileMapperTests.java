package ltd.newimg;

import ltd.newimg.mapper.FileMapper;
import ltd.newimg.model.dto.FileSaveDTO;
import ltd.newimg.util.NanoIdUtil;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-06-19 17:14
 */
@SpringBootTest
public class FileMapperTests {

    @Resource
    FileMapper fileMapper;

    @Test
    public void saveFileTest() {
        try {
            fileMapper.saveFile(new FileSaveDTO("./", NanoIdUtil.randomNanoId(), new FileInputStream(new File("D:\\Eleun\\下载\\1655530765232sxt.png"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void accessFileTest() {
        System.out.println(fileMapper.accessFile(new FileSaveDTO("./", ".;adfadsf", null)));
    }
}
