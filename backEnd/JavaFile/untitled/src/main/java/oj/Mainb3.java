package oj;

public class Mainb3 {
    public static void main(String[] args) {
        System.out.println("int f(double x,double x)".replaceAll(".+ .+\\(| .+,| .+\\)|\\)", "|"));
        System.out.println("int f()".replaceAll(".+ .+\\(| .+,| .+\\)|\\)", "|"));
        System.out.println("f(double,double)".replaceAll(".+\\(|,|\\)", "|"));
        System.out.println("f()".replaceAll(".+\\(|,|\\)", "|"));
    }
}
