package oj;

public class Example extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("run");
    }

    public static void main(String[] args) {
            String classFile = "com.jd.".replaceAll(".","/") + "MyClass.class";
            System.out.println(classFile);
    }
}