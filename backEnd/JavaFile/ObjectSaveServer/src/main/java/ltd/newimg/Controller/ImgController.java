package ltd.newimg.controller;

import ltd.newimg.service.ObjectSaveService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-06-19 10:05
 */
@Controller
@RequestMapping("/img")
public class ImgController {

    @Resource
    ObjectSaveService objectSaveService;

    @Value("${fileSave.imgDir}")
    String imgSaveDir;

    @ResponseBody
    @RequestMapping("/upload")
    public String imgUpload(String fileName, MultipartFile file, String access_token) {
        return objectSaveService.saveFile(imgSaveDir, fileName, file).toJSONString();
    }

    @RequestMapping("/download")
    public ResponseEntity<FileSystemResource> accessFile(String fileName, String access_token) {
        return objectSaveService.accessFile(imgSaveDir, fileName);
    }
}
