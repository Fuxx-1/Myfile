package ltd.newimg.mapper;

import com.alibaba.fastjson.JSONObject;

import ltd.newimg.model.dto.FileSaveDTO;
import ltd.newimg.util.ReturnUtil;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

/**
 * @author Fuxx-1@Github
 * @Description
 * @create 2022-06-19 10:04
 */
@Component
public class FileMapper {

    /**
     * 保存文件
     * @param fileSaveDto 按要求传入FileSave对象
     * @return JSONObject格式的上传结果
     */
    public JSONObject saveFile(FileSaveDTO fileSaveDto) {
        OutputStream fileStream = null;
        // 1k的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 本地文件
        File tempFile = new File(fileSaveDto.getSaveDir());
        // 不存在则创建
        if (!tempFile.exists()) {
            tempFile.mkdirs();
        }
        try {
            fileStream = new FileOutputStream(tempFile.getPath() + File.pathSeparator + fileSaveDto.getFileName());
            // 读取并保存文件
            while ((len = fileSaveDto.getFile().read(bs)) != -1) {
                fileStream.write(bs, 0, len);
            }
            return ReturnUtil.returnObj("上传成功", 0, null);
        } catch (Exception e) {
            Logger.getLogger("l.n.M.FileMapper.saveFile").warning(e.toString());
            return ReturnUtil.returnObj("上传失败", -1, null);
        } finally {
            try {
                if (fileStream != null) {
                    fileStream.close();
                }
            } catch (Exception e) {
                Logger.getLogger("l.n.M.FileMapper.saveFile").warning(e.toString());
            }
        }
    }

    /**
     * 保存文件
     * @param fileSaveDto 按要求传入FileSave对象
     * @return File形式的文件
     */
    public File accessFile(FileSaveDTO fileSaveDto) {
        return new File(fileSaveDto.getSaveDir(), fileSaveDto.getFileName());
    }

    public long getSpaceRemaining() {
        File[] roots = File.listRoots();
        long totalSpace = roots[0].getTotalSpace();
        long freeSpace = roots[0].getFreeSpace();
        if ((totalSpace - freeSpace) / (float) totalSpace > 0.85) {
            // TODO：磁盘占用高后的提示
        }
        return freeSpace;
    }
}
