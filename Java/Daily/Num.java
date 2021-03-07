package Daily;

class NumArray {
    static int[] sums;

    public static void NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public static int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
public class Num {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        NumArray.NumArray(a);
        System.out.println(NumArray.sumRange(0, 3));
    }
}
