class Thoughtworks {
    private String name, major;

    public Thoughtworks() {
    }

    public Thoughtworks(String name, String major) {
        this.name = name;
        this.major = major;
    }
    //构造
    public void setname(String name) {
        this.name = name;
    }

    public void setmajor(String major) {
        this.major = major;
    }
    //set
    public String getname() {
        return name;
    }

    public String getmajor() {
        return major;
    }
    //get
    public void show() {
        System.out.println("我是" + name + ",我学的方向是" + major);
    }
    //show the information
}

class Front_end extends Thoughtworks {
    public Front_end() {
    }

    public Front_end(String name, String major) {
        super(name, major);
    }
    //构造
    public void study() {
        System.out.println("我爱学CSS");
    }
    //show information
}

class Backstage extends Thoughtworks {
    public Backstage() {
    }

    public Backstage(String name, String major) {
        super(name, major);
    }
    //构造
    public void study() {
        System.out.println("我爱学Java");
    }
    //show information
}

public class Ans {
    public static void main(String[] args) {
        Front_end front = new Front_end("1", "1");
        front.setname("Example1");
        front.setmajor("前端");   //set验证
        front.show();
        front.study();
        System.out.println("name: " + front.getname() + "   major: " + front.getmajor());
        //get验证
        System.out.println("--------------------分割线--------------------");
        Backstage end = new Backstage("2", "2");
        end.setname("Example2");
        end.setmajor("后台");     //set验证
        end.show();
        end.study();
        System.out.println("name: " + end.getname() + "   major: " + end.getmajor());
        //get验证
    }
}