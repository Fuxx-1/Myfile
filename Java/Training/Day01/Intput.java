import java.util.Scanner;

public class Intput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        input.close();
        System.out.print(i);
    }
}