package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, product = 1, result = 0;
        for (int r = 0; r < nums.length; r++) {
            product *= nums[r];
            while (l <= r && product >= k) {
                product /= nums[l++];
            }
            result += r - l + 1;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
