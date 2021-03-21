import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * @create: 2021-03-21 15:26
 **/
public class FileUtil {
    public static String load(File file) {
        Scanner scan = null;
        try{
            scan new Scanner(file);   //进行文件加载
            if(scan.hasNext()) {
                String str = scan.next();  //获取数据
                return str;
            }
            return null;
        }catch(Exception e){
            return null;
        }finally{
            if(scan != null) {
                scan.close();
            }
        }
    }
    public static void static boolean append(File file, String content) {
        PrintStream out = null ;
        try{
            out = new PrintStream(new FileOutputStream(file,true));
            out.print(content);  //内容追加
            return true;
        }catch (Exception e){
            return false;
        }finally{
            if(out != null) {
                out.close();
            }
        }
    }
}
