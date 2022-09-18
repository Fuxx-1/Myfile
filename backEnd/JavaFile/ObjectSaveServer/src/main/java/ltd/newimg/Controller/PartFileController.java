package ltd.newimg.controller;

import ltd.newimg.model.DTO.PartFileDTO;
import ltd.newimg.model.DTO.PartFileInfoDTO;
import ltd.newimg.service.PartFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Eleun
 * @Description
 * @create 2022-09-16 9:46
 */
@Controller
@RequestMapping("/partFile")
public class PartFileController {

    @Resource
    PartFileService partFileService;

    /**
     * 初始化上传（准备上传）
     * @param partFileInfoDTO 文件信息
     * @return 是否允许上传及是否需要上传
     */
    @ResponseBody
    @RequestMapping("/init")
    public String initPartFileUpload(PartFileInfoDTO partFileInfoDTO) {
        return partFileService.initPartFileUpload(partFileInfoDTO).toJSONString();
    }

    /**
     * 分片文件上传接口
     * @param partFileDTO 分片文件信息
     * @return 是否成功
     */
    @ResponseBody
    @RequestMapping("/upload")
    public String partFileUpload(PartFileDTO partFileDTO) {
        return partFileService.partFileUpload(partFileDTO).toJSONString();
    }

    /**
     * 查询上传
     * @param partFileInfoDTO
     * @return 上传文件的进度
     */
    @ResponseBody
    @RequestMapping("/query")
    public String queryFileUploadCondition(PartFileInfoDTO partFileInfoDTO) {
        return partFileService.queryFileUploadCondition(partFileInfoDTO).toJSONString();
    }

    /**
     * 合并文件
     * @param partFileInfoDTO 文件信息
     * @return 文件信息
     */
    @ResponseBody
    @RequestMapping("/merge")
    public String mergeFile(PartFileInfoDTO partFileInfoDTO){
        return partFileService.mergeFile(partFileInfoDTO).toJSONString();
    }

    /**
     * 取消文件上传
     * @param partFileInfoDTO 文件信息
     * @return 文件信息
     */
    @ResponseBody
    @RequestMapping("/cancel")
    public String cancelFile(PartFileInfoDTO partFileInfoDTO) {
        return partFileService.cancelFile(partFileInfoDTO).toJSONString();
    }

}
