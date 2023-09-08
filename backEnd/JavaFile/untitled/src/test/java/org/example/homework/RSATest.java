package org.example.homework;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSATest {
    static BigInteger n;
    static BigInteger e;
    static BigInteger d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initRSA();
        System.out.println(
                "N: " + n +
                        "\ne: " + e +
                        "\nd: " + d
        );
        while (true) {
            System.out.println("=====\n请输入密文（纯数字）：");
            BigInteger text = sc.nextBigInteger();
            BigInteger en = encrypt(text, n, e);
            BigInteger de = decrypt(en, n, d);
            System.out.println("密文：" + en);
            System.out.println("解密后：" + de);
            System.out.println("自动比对：" + de.equals(text));
            System.out.println("=====");
        }
    }

    public static void initRSA() {
        /* 随机大素数p, q */
        BigInteger p = BigInteger.probablePrime(new Random().nextInt(100) + 100, new Random());
        BigInteger q = BigInteger.probablePrime(new Random().nextInt(100) + 100, new Random());
        /* 计算乘积 */
        n = p.multiply(q);
        /* 计算e, d */
        BigInteger phi_n = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        do {
            e = new BigInteger(new Random().nextInt(phi_n.bitLength() - 1) + 1, new Random());
        } while (e.compareTo(phi_n) != -1 || e.gcd(phi_n).intValue() != 1);
        d = e.modPow(new BigInteger("-1"), phi_n);
    }

    /**
     * 加密
     * <p> C=M^e(mod n)
     */
    public static BigInteger encrypt(BigInteger M, BigInteger n, BigInteger e) {
        return M.modPow(e, n);
    }

    /**
     * 解密
     * <p> M=C^d(mod n)
     */
    public static BigInteger decrypt(BigInteger C, BigInteger n, BigInteger d) {
        return C.modPow(d, n);
    }
}
