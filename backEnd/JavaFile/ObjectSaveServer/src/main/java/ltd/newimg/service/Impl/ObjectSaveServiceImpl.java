package ltd.newimg.service.impl;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.mapper.FileMapper;
import ltd.newimg.model.DTO.FileSaveDTO;
import ltd.newimg.service.ObjectSaveService;
import ltd.newimg.util.ReturnUtil;
import ltd.newimg.util.TimeUtil;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * 文件服务实现层
 * 
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-06-18 23:25
 */
@Service
public class ObjectSaveServiceImpl implements ObjectSaveService {

    @Resource
    FileMapper fileMapper;
    // 文件持久层接口

    /**
     * 保存文件
     *
     * @param saveDir  保存地址
     * @param fileName 文件名
     * @param file     文件
     * @return 是否成功
     */
    @Override
    public JSONObject saveFile(String saveDir, String fileName, MultipartFile file) {
        try {
            FileSaveDTO fDto = new FileSaveDTO(saveDir, fileName, file.getInputStream());
            fileMapper.saveFile(fDto);
            return ReturnUtil.returnObj("保存成功", 0, new HashMap<String, Object>(1) {
                {
                    put("fileName", fileName);
                }
            });
        } catch (Exception e) {
            Logger.getLogger("l.n.s.I.ObjectSaveServiceImpl.saveFile").warning(e.toString());
            return ReturnUtil.returnObj("保存失败", -1, null);
        }
    }

    /**
     * 获取文件
     *
     * @param fileName 文件名
     * @return ResponseEntity<FileSystemResource> 文件 默认缓存
     */
    @Override
    public ResponseEntity<FileSystemResource> accessFile(String fileName) {
        File file = fileMapper.accessFile(new FileSaveDTO("./", fileName, null));
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
