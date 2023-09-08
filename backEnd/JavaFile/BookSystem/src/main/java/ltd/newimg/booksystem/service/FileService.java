package ltd.newimg.booksystem.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


public interface FileService {
    /**
     * 上传图片
     * @param file 图片文件
     * @return 上传结果
     */
    JSONObject uploadFile(File file);

    /**
     * 获取图片
     *
     * @param hash 图片hash值
     * @return 图片路径
     */
    ResponseEntity<FileSystemResource> getFile(String hash);
}
