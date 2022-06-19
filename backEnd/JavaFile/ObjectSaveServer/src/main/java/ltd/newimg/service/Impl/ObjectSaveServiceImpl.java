package ltd.newimg.service.Impl;

import ltd.newimg.Mapper.FileMapper;
import ltd.newimg.Model.dto.FileSaveDto;
import ltd.newimg.service.ObjectSaveService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-06-18 23:25
 */
public class ObjectSaveServiceImpl implements ObjectSaveService {

    @Resource
    FileMapper fileMapper;
    // 文件持久层接口

    /**
     * 保存文件
     *
     * @param file 文件
     * @return 是否成功
     */
    @Override
    public String saveFile(MultipartFile file) {
        return null;
    }

    /**
     * 获取文件
     *
     * @param fileName 文件名
     * @return ResponseEntity<FileSystemResource> 文件 默认缓存
     */
    @Override
    public ResponseEntity<FileSystemResource> accessFile(String fileName) {
        File file = fileMapper.accessFile(new FileSaveDto("./", fileName, null));
        if (file.exists()){
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "public");
            headers.add("Content-Disposition", "attachment; filename=" + file.getName());
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            headers.add("Last-Modified", new Date().toString());
            headers.add("ETag", String.valueOf(System.currentTimeMillis()));
            return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/octet-stream")).body(new FileSystemResource(file));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
