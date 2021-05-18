import java.util.Arrays;

/**
 * @create: 2021-03-21 11:17
 **/
public class Service {
    private Student [] students = new Student[] {
            new Student(1,"张三",0), new Student(2,"李四",0),
            new Student(3,"王五",0), new Student(4,"赵六",0)};
    public boolean inc(long sid) {
        for (Student student : students) {
            if (student.getSid() == sid) {  //获取了指定的编号
                student.setVote(student.getVote() + 1);  //票数增长
                return true;
            }
        }
        return false;
    }
    public Student[] getData() {
        return this.students;
    }
    public Student[] result() {
        Arrays.sort(this.students);
        return this.students ;
    }
}
