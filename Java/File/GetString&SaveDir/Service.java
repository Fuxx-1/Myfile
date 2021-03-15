import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @create: 2021-03-15 21:53
 **/
public class Service {
    public static final String Save_Dir = "D:" + File.separator + "Test" + File.separator;
    private String name;
    private String content;

    public Service() {
        this.name = InputUtil.getString("请输入保存的文件名称：");
        this.content = InputUtil.getString("请输入保存的文件内容：");
    }

    /**
     * 定义文件的保存处理方法
     *
     * @return 返回是否保存成功
     */
    public boolean Save() {
        File file = new File(Save_Dir + this.name);
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(file));
            out.print(this.content);
        } catch (FileNotFoundException e) {
            return false;
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return true;
    }
}
