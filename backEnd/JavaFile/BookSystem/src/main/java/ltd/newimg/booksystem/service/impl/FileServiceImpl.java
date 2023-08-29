package ltd.newimg.booksystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.booksystem.service.FileService;
import org.springframework.web.multipart.MultipartFile;


public class FileServiceImpl implements FileService {

    /**
     * 上传图片
     *
     * @param file 图片文件
     * @return 上传结果
     */
    @Override
    public JSONObject uploadPicture(MultipartFile file) {
        return null;
    }

    /**
     * 获取图片
     *
     * @param hash 图片hash值
     * @return 图片路径
     */
    @Override
    public String getFile(String hash) {
        return null;
    }
}
