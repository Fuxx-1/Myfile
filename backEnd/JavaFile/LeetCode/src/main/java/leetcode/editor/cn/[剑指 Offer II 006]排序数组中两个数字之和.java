package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) return new int[] {left, right};
            if (numbers[left] + numbers[right] < target) left++;
            if (numbers[left] + numbers[right] > target) right--;
        }
        return new int[2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
