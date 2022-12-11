package ltd.newimg;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static int logLevel = 2;

    public static void main(String[] args) {
        File temp = new File("./temp");
        isContinue("Current directory:" + temp.getAbsolutePath(), true);
        File out = new File("./out");
        if (!out.exists()) {
            if (!out.mkdirs()) {
                // 创建输出目录失败
                throw new RuntimeException("Directory Create Error");
            }
        }
        if (!temp.isDirectory()) {
            // 非目录，无法处理
            warn("Please put files into /temp/[folders/files]");
        } else {
            info("Begin to init");
            for (File file : temp.listFiles()) {
                if (file.isDirectory()) {
                    for (File listFile : file.listFiles()) {
                        File file1 = new File(out.getAbsoluteFile() + File.separator + listFile.getName().split("\\.")[0]);
                        if (!file1.exists()) {
                            file1.mkdirs();
                        }
                        StringBuilder fileName = new StringBuilder();
                        fileName.append(file1.getAbsoluteFile()).append(File.separator);
                        fileName.append(file.getName().replaceAll("-", "_"));
                        fileName.append("_网络2003_");
                        fileName.append(listFile.getName().replaceAll("报告", ""));
                        listFile.renameTo(new File(fileName.toString()));
                    }
                }
            }
        }
    }

    public static boolean isContinue(String msg, Boolean isAbort) {
        System.out.printf("[WARN] " + msg + ", could you want to continue? [Y/n] ");
        String next = scanner.nextLine();
        if (!(next.length() == 0 || 'Y' == next.charAt(0) || 'y' == next.charAt(0))) {
            if (isAbort) {
                throw new RuntimeException("Aborted By User");
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public static void warn(String msg) {
        if (logLevel > 0) System.out.println("[WARN] " + msg);
    }

    public static void info(String msg) {
        if (logLevel > 1) System.out.println("[INFO] " + msg);
    }

    public static void debug(String msg) {
        if (logLevel > 2) System.out.println("[DEBUG] " + msg);
    }
}