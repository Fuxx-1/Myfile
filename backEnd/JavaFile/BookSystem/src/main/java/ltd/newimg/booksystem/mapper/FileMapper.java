package ltd.newimg.booksystem.mapper;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

@Component
public class FileMapper {

    @Value("${file.save_path}")
    String savePath;

    /**
     * 保存文件
     *
     * @param file 按要求传入 file
     * @return JSONObject格式的上传结果
     */
    public String saveFile(File file) {
        String hex = null;
        OutputStream fileStream = null;
        // 本地文件
        File tempFile = new File(savePath);
        InputStream input = null;
        // 不存在则创建
        if (!tempFile.exists()) tempFile.mkdirs();
        try {
            input = Files.newInputStream(file.toPath());
            hex = DigestUtils.md5Hex(Files.newInputStream(file.toPath()));
            if (new File(tempFile.getPath() + File.separator + hex + ".jpg").length() != 0) return hex;
            fileStream = Files.newOutputStream(Paths.get(tempFile.getPath() + File.separator + hex));
            // 使用IOUtils将InputStream内容复制到OutputStream
            IOUtils.copy(input, fileStream);
            return hex;
        } catch (Exception e) {
            Logger.getLogger("l.n.M.FileMapper.saveFile").warning(e.toString());
            return null;
        } finally {
            try {
                if (fileStream != null) fileStream.close();
                if (input != null) input.close();
            } catch (Exception e) {
                Logger.getLogger("l.n.M.FileMapper.saveFile").warning(e.toString());
            }
        }
    }

    /**
     * 保存文件
     *
     * @param hex 哈希值
     * @return File形式的文件
     */
    public File accessFile(String hex) {
        return new File(savePath, hex);
    }

//    public long getSpaceRemaining() {
//        File[] roots = File.listRoots();
//        long totalSpace = roots[0].getTotalSpace();
//        long freeSpace = roots[0].getFreeSpace();
//        if ((totalSpace - freeSpace) / (float) totalSpace > 0.85) {
//            // TODO：磁盘占用高后的提示
//            System.out.println("磁盘占用高!!!!");
//        }
//        return freeSpace;
//    }
}
