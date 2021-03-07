import java.io.File;

public class JavaDemo {
    public static void main(String[] args) throws Exception{
        File file = new File("d:"+File.separator+"hello"+File.separator+"demo"+File.separator+"message"+File.separator+"mldn.txt");
        if(file.exists()) {
            file.delete();    //删除文件
        }else {    //文件不存在
            System.out.println(file.createNewFile()) ;   //创建新的文件
        }
    }
}