package ltd.newimg.booksystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.booksystem.Util.ReturnUtil;
import ltd.newimg.booksystem.Util.TimeUtil;
import ltd.newimg.booksystem.Util.en.ReturnCodeEnum;
import ltd.newimg.booksystem.mapper.FileMapper;
import ltd.newimg.booksystem.service.FileService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

@Service
public class FileServiceImpl implements FileService {

    @Resource
    FileMapper fileMapper;

    /**
     * 上传图片
     *
     * @param file 图片文件
     * @return 上传结果
     */
    @Override
    public JSONObject uploadFile(File file) {
        String hex = fileMapper.saveFile(file); // file.getInputStream()
        if (hex != null) {
            return ReturnUtil.returnObj(ReturnCodeEnum.SUCCESS, hex);
        } else {
            return ReturnUtil.returnObj(ReturnCodeEnum.SYSTEM_FAILED, null);
        }
    }

    /**
     * 获取图片
     *
     * @param hash 图片hash值
     * @return 图片路径
     */
    @Override
    public ResponseEntity<FileSystemResource> getFile(String hash) {
        File file = fileMapper.accessFile(hash);
        if (file.exists()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "public");
            headers.add("Content-Disposition", "attachment; filename=" + file.getName());
            headers.add("Expires", TimeUtil.getTimeAfter(null, 0, 1, 0, 0, 0, 0));
            headers.add("Last-Modified", new Date().toString());
            headers.add("ETag", String.valueOf(file.length()));
            return ResponseEntity.ok().headers(headers).contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new FileSystemResource(file));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
