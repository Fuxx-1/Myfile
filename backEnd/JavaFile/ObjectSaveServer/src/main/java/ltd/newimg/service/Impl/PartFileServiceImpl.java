package ltd.newimg.service.impl;

import com.alibaba.fastjson.JSONObject;
import ltd.newimg.mapper.FileMapper;
import ltd.newimg.model.DTO.FileSaveDTO;
import ltd.newimg.model.DTO.PartFileDTO;
import ltd.newimg.model.DTO.PartFileInfoDTO;
import ltd.newimg.service.PartFileService;
import ltd.newimg.util.ReturnUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * @author Eleun
 * @Description
 * @create 2022-07-26 17:04
 */
@Service
public class PartFileServiceImpl implements PartFileService {

    @Resource
    FileMapper fileMapper;

    @Value("${fileSave.bigFileDir}")
    String bigFileDir;

    /**
     * 初始化上传（准备上传）
     *
     * @param partFileInfoDTO
     * @return 是否允许上传及是否需要上传
     */
    @Override
    public JSONObject initPartFileUpload(PartFileInfoDTO partFileInfoDTO) {
        String saveDir = bigFileDir + File.separator + partFileInfoDTO.getMD5() + File.separator + partFileInfoDTO.getSHA1();
        // 判断是否允许上传
        if (partFileInfoDTO.getFileSize() * 10 > fileMapper.getSpaceRemaining()) {
            // 检查空间是否充足
            return ReturnUtil.returnObj("初始化失败，文件过大", -1000, null);
        }
        File file = new File(saveDir + File.separator + "verify.info");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            // 文件已存在
            try {
                return ReturnUtil.returnObj("文件已存在或已被初始化", -1001, getInfo(saveDir));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            // 创建并保存保存信息文件
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            out.writeObject(partFileInfoDTO);
            out.close();
//            out = new BufferedWriter(new FileWriter(file, false));
//            out.write(partFileInfoDTO.toString());
//            out.close();
            return ReturnUtil.returnObj("初始化成功", 0, getInfo(saveDir));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 返回成功
    }

    /**
     * 分片文件上传接口
     *
     * @param partFileDTO 分片文件信息
     * @return 是否成功
     */
    @Override
    public JSONObject partFileUpload(PartFileDTO partFileDTO) {
        String saveDir = bigFileDir + File.separator + partFileDTO.getTotalMD5() + File.separator + partFileDTO.getTotalSHA1();
        String fileName = partFileDTO.getChunkIndex() + ".part";
        // 验证文件
        try {
            if (!new File(saveDir).exists()) {
                // 文件夹不存在
                return ReturnUtil.returnObj("请先初始化该文件", -1002, null);
            }
            String MD5 = DigestUtils.md5Hex(partFileDTO.getFile().getInputStream());
            if (!MD5.equals(partFileDTO.getMD5())) {
                // MD5校验失败
                return ReturnUtil.returnObj("校验失败", -1003, null);
            }
            // 文件验证无误
            // 保存文件
            fileMapper.saveFile(new FileSaveDTO(saveDir, fileName, partFileDTO.getFile().getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 返回成功
        try {
            return ReturnUtil.returnObj("上传成功", 0, getInfo(saveDir));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询上传
     *
     * @param partFileInfoDTO
     * @return 上传文件的进度
     */
    @Override
    public JSONObject queryFileUploadCondition(PartFileInfoDTO partFileInfoDTO) {
        // 查询文件上传进度
        String saveDir = bigFileDir + File.separator + partFileInfoDTO.getMD5() + File.separator + partFileInfoDTO.getSHA1();
        File[] files = new File(saveDir).listFiles();
        String[] fileNames = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            fileNames[i] = files[i].getName();
        }
        // 返回信息
        return ReturnUtil.returnObj("查询成功", 0, fileNames);
    }

    /**
     * 合并文件
     *
     * @param partFileInfoDTO
     * @return 文件信息
     */
    @Override
    public JSONObject mergeFile(PartFileInfoDTO partFileInfoDTO) {
        // 变量
        String saveDir = bigFileDir + File.separator + partFileInfoDTO.getMD5() + File.separator + partFileInfoDTO.getSHA1();
        String fileName = "file" + partFileInfoDTO.getSuffix();
        // 检测是否已合并
        try {
            for (File file : new File(saveDir).listFiles()) {
                if (file.getName().matches("file.*")) {
                    return ReturnUtil.returnObj("该文件已被合并", -1001, getInfo(saveDir));
                }
            }
        } catch (Exception NullPointerException) {
            //ignore
        }
        // 尝试合并
        // 验证MD5及SHA1
        try {
            if (!getInfo(saveDir).equals(partFileInfoDTO)) {
                // 验证异常
                return ReturnUtil.returnObj("验证异常", -1004, null);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 新文件
        File mergedFile = new File(saveDir + File.separator + fileName);
        if (!mergedFile.getParentFile().exists()) {
            mergedFile.mkdirs();
        }
        try {
            mergedFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // 输入流、输出流，负责读取、写入文件
        FileInputStream in = null;
        FileOutputStream out = null;
        FileChannel inChannel = null, outChannel = null;
        // 将每个文件一次写入目标文件
        try {
            out = new FileOutputStream(mergedFile);
            outChannel = out.getChannel();
            if (new File(saveDir).isDirectory()) {
                // 记录新文件最后一个数据的位置
                long start = 0;
                for (int i = 0; i < partFileInfoDTO.getChunkTotal(); i++) {
                    File file = new File(saveDir + File.separator + i + ".part");
                    // 初始化输入
                    in = new FileInputStream(file);
                    inChannel = in.getChannel();
                    // 从inChannel中读取file.length()长度的数据，写入outChannel的start处
                    outChannel.transferFrom(inChannel, start, file.length());
                    // 记录偏移量
                    start += file.length();
                    // 关闭输入流
                    in.close();
                    inChannel.close();
                }
            }
            out.close();
            outChannel.close();
            if (DigestUtils.md5Hex(Files.newInputStream(mergedFile.toPath())).equals(partFileInfoDTO.getMD5()) &&
                    DigestUtils.sha1Hex(Files.newInputStream(mergedFile.toPath())).equals(partFileInfoDTO.getSHA1())) {
                File[] files = new File(saveDir).listFiles();
                for (File file : files) {
                    if (file.getName().matches("[0-9]{1,}.part")) {
                        file.delete();
                    }
                }
                return ReturnUtil.returnObj("合并成功", 0, getInfo(saveDir));
            } else {
                delFile(bigFileDir + File.separator + partFileInfoDTO.getMD5());
                return ReturnUtil.returnObj("文件传输异常", -1005, null);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 取消文件上传
     *
     * @param partFileInfoDTO
     * @return 文件信息
     */
    @Override
    public JSONObject cancelFile(PartFileInfoDTO partFileInfoDTO) {
        /* 变量定义 */
        String saveDir = bigFileDir + File.separator + partFileInfoDTO.getMD5() + File.separator + partFileInfoDTO.getSHA1();
        File[] files = new File(saveDir).listFiles();
        /* 检测是否已合并 */
        try {
            for (File file : new File(saveDir).listFiles()) {
                if (file.getName().matches("file.*")) {
                    return ReturnUtil.returnObj("该文件已被合并", -1001, null);
                }
            }
        } catch (Exception e) {
            //ignore
        }
        /* 该文件未被合并，可以删除 */
        if (delFile(saveDir)) {
            return ReturnUtil.returnObj("取消成功", 0, null); // 返回成功
        } else {
            return ReturnUtil.returnObj("取消失败", -1006, null);
        }

    }

    /**
     * 递归删除文件目录
     *
     * @param FileDir 要删除的路径
     * @return 是否成功
     */
    private boolean delFile(String FileDir) {
        boolean isSuccess = true; // 定义标志是否删除成功的变量
        File file = new File(FileDir); // 定义该文件或目录
        if (file.isDirectory()) {
            /* 该路径为目录，删除目录下的所有文件 */
            File[] files = new File(FileDir).listFiles(); // 获取路径列表
            for (File childFile : files) {
                /* 删除子路径 */
                if (file.isDirectory()) {
                    isSuccess = isSuccess && delFile(childFile.getPath()); // 递归删除
                } else {
                    isSuccess = isSuccess && childFile.delete(); // 文件删除
                }
            }
        }
        isSuccess = isSuccess && file.delete(); // 删除该路径
        return isSuccess;
    }

    private PartFileInfoDTO getInfo(String saveDir) throws IOException, ClassNotFoundException {
        return (PartFileInfoDTO) new ObjectInputStream(Files.newInputStream(new File(saveDir + File.separator + "verify.info").toPath())).readObject();
    }
}
