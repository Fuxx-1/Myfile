package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Optional;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int pivotIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        if (nums[nums.length - 1] - nums[0] == 0) return 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[nums.length - 1] - nums[i]) return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
