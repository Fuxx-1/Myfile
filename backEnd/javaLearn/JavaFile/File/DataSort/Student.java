/**
 * @create: 2021-03-16 22:01
 **/
public class Student implements Comparable<Student> {
    private String name;
    private double Score;


    public Student(String name, double score) {
        this.name = name;
        Score = score;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + Score + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAge() {
        return Score;
    }

    public void setAge(int age) {
        this.Score = age;
    }

    @Override
    public int compareTo(Student o) {
        if (this.Score > o.Score) {
            return -1;
        } else if (this.Score < o.Score) {
            return 1;
        } else {
            return 0;
        }
    }
}
