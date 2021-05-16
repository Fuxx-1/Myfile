public class Main {
    public static void main(String[] args) {
        Service numberserivce = new Service();
        int[] result = numberserivce.stat(5);
        System.out.println("最大值：" + result[0]);
        System.out.println("最小值：" + result[1]);
    }
}
