import java.io.File;
import java.util.Arrays;

/**
 * @create: 2021-03-16 22:07
 **/
public class Service {
    private static final File SAVE_FILE = new File("D:" +File.separator + "student.txt");
    private String content ;
    private Student[] students;
    public Service() {
        this.content = FileUtil.load(SAVE_FILE);   //读取已有的数据文件
        this.handle();   //进行数据处理
    }
    public void append(String str){
        if(str.startwith("|")) {    //最前面有|
            str = str.substring(1);    //截取后面的部分
        }
        if(!str.endwith("|")) {    //数据合理，可以直接追加
            str = str + "|";    //与后面的数据进行分割
        }
        FileUtil.append(SAVE_FILE,str);     //数据的追加处理
    }
    private void handle(){   //进行字符串数据的处理操作
        if(this.content == null || "".equals(this.content)) {
            return ;  //没有数据可以处理
        }
        String[] result = this.content.split("\\|") ;  //拆分数据
        this.students = new Student[result.length];
        for (int x = 0 ;x < result.length ; x ++) {
            String[] temp = result[x].split(":");
            this.students[x] = new Student(temp[0],Double.parseDouble(temp[1])) ;
        }
    }
    public Student[] getData() {
        Arrays.sort(this.students);
        return this.students;
    }
}