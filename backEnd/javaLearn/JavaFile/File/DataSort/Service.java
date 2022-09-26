import java.util.Arrays;

/**
 * @create: 2021-03-16 22:07
 **/
public class Service {
    private String content;
    private Student[] students;

    public Service(String content) {
        this.content = content;
        this.handle();
    }

    private void handle() {
        String[] Result = this.content.split("\\|");
        this.students = new Student[Result.length];
        for (int i = 0; i < Result.length; i++) {
            String[] temp = Result[i].split(":");
            this.students[i] = new Student(temp[0], Double.parseDouble(temp[1]));
        }
    }

    public Student[] getData() {
        Arrays.sort(this.students);
        return this.students;
    }
}
