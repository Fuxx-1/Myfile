package ltd.newimg.service;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.model.DTO.PartFileInfoDTO;
import ltd.newimg.model.DTO.PartFileDTO;

/**
 * @author Eleun
 * @Description
 * @create 2022-07-26 15:08
 */
public interface PartFileService {

    /**
     * 初始化上传（准备上传）
     * @param partFileInfoDTO 文件信息
     * @return 是否允许上传及是否需要上传
     */
    JSONObject initPartFileUpload(PartFileInfoDTO partFileInfoDTO);

    /**
     * 分片文件上传接口
     * @param partFileDTO 分片文件信息
     * @return 是否成功
     */
    JSONObject partFileUpload(PartFileDTO partFileDTO);

    /**
     * 查询上传
     * @param partFileInfoDTO
     * @return 上传文件的进度
     */
    JSONObject queryFileUploadCondition(PartFileInfoDTO partFileInfoDTO);

    /**
     * 合并文件
     * @param partFileInfoDTO 文件信息
     * @return 文件信息
     */
    JSONObject mergeFile(PartFileInfoDTO partFileInfoDTO);

    /**
     * 取消文件上传
     * @param partFileInfoDTO 文件信息
     * @return 文件信息
     */
    JSONObject cancelFile(PartFileInfoDTO partFileInfoDTO);

}
