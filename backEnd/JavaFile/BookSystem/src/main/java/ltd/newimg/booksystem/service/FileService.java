package ltd.newimg.booksystem.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;


public interface FileService {
    /**
     * 上传图片
     * @param file 图片文件
     * @return 上传结果
     */
    JSONObject uploadPicture(MultipartFile file);

    /**
     * 获取图片
     * @param hash 图片hash值
     * @return 图片路径
     */
    String getFile(String hash);
}
