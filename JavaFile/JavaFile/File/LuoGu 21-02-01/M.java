import java.util.*;
import java.math.*;

public class M {
    public static void main(String args[]){
        BigInteger ans = new BigInteger("0"), temp;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= n; i++){
            temp = new BigInteger("1");
            for (int j = 1; j <= i; j++){
                temp = temp.multiply(BigInteger.valueOf(j));
            }
            ans = temp.add(ans);
        }
        System.out.println(ans);
    }
}