package ltd.newimg;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.DecimalFormat;

/**
 * @author Fuxx-1@Github
 * @Description
 * @date 2022/07/21 12:04
 */
public class attrTest {
    @Test
    public void Test1() {
        //设置保留位数
        DecimalFormat df = new DecimalFormat("0.00");
        //获取电脑所有磁盘信息
        File[] roots = File.listRoots();
        for (int i = 0; i < roots.length; i++) {
            File file = roots[i];
//			File file = new File("D:");
            System.out.println(file);
            long totalSpace = roots[i].getTotalSpace();
            long freeSpace = roots[i].getFreeSpace();
            long usedSpace = totalSpace - freeSpace;

            //转化占用磁盘大小
            Float totalSpaceG = Float.valueOf(df.format((float) totalSpace / 1024 / 1024 / 1024));
            Float freeSpaceG = Float.valueOf(df.format((float) freeSpace / 1024 / 1024 / 1024));
            Float usedSpaceG = Float.valueOf(df.format((float) usedSpace / 1024 / 1024 / 1024));
            System.out.println("总空间大小 : " + totalSpaceG + "G");
            System.out.println("剩余空间大小 : " + freeSpaceG + "G");
            System.out.println("已用空间大小 : " + usedSpaceG + "G");
        }
//        String str = "123.1231.123.asdfg.1234.sdfs.zp";
//        String[] str1 = str.split("\\.");
//        System.out.println("." + str1[str1.length - 1]);
    }

    @Test
    public void Test2() throws ArrayIndexOutOfBoundsException {
        char[] test = "abc".toCharArray();
        try {
            for (int i = 0; i < test.length; i++) {
                System.out.println(test[i + 1]);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("test");
    }
}
