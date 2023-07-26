package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = nums[0], right = 0, result = Integer.MAX_VALUE;
        while (sum >= target || right < nums.length - 1) {
            if (sum < target) {
                sum += nums[++right];
            } else {
                result = Math.min(right - left + 1, result);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
