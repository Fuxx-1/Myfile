import java.util.*;

public class E {
    public static void main(String args[]){
        Scanner in = (new Scanner(System.in));
        int[] a = new int[110];
        int temp, i = 0;
        temp = in.nextInt();
        while (temp != 0){
            a[i++] = temp;
            temp = in.nextInt();
        }
        while (i != 0){
            System.out.printf(a[--i]+" ");
        }
    }
}