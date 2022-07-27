package ltd.newimg.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Eleun
 * @Description
 * @create 2022-05-04 23:05
 */
public interface ObjectSaveService {

    /**
     * 保存文件
     * @param saveDir 保存地址
     * @param fileName 文件名
     * @param file 文件
     * @return 是否成功
     */
    JSONObject saveFile(String saveDir, String fileName, MultipartFile file);

    /**
     * 获取文件
     * @param fileName 文件名
     * @return ResponseEntity<FileSystemResource> 文件 默认缓存
     */
    ResponseEntity<FileSystemResource> accessFile(String fileName);
}
