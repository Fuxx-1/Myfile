package ltd.newimg.booksystem.controller;

import ltd.newimg.booksystem.Util.ReturnUtil;
import ltd.newimg.booksystem.Util.en.ReturnCodeEnum;
import ltd.newimg.booksystem.model.vo.BookQueryByNameVO;
import ltd.newimg.booksystem.service.BookService;
import ltd.newimg.booksystem.service.FileService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    @Resource
    FileService fileService;

    @PostMapping("")
    String addFile(MultipartFile multipartFile) {
        try {
            File file = File.createTempFile("temp", null);
            multipartFile.transferTo(file);
            return fileService.uploadFile(file).toJSONString();
        } catch (IOException e) {
            Logger.getLogger("FileController").warning(e.toString());
            return ReturnUtil.returnMsg(ReturnCodeEnum.SYSTEM_FAILED, null);
        }
    }

    @GetMapping("")
    ResponseEntity<FileSystemResource> queryFile(@NonNull String hex) {
        return fileService.getFile(hex);
    }
}
