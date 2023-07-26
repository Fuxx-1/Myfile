package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int[] newNums = new int[nums.length + 1];
        newNums[0] = 0;
        for (int i = 1; i < newNums.length; i++) {
            newNums[i] = newNums[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
            if (map.get(newNums[i]) == null) map.put(newNums[i], i);
        }
        for (int i = newNums.length - 1; i >= 0; i--) {
            if (map.get(newNums[i]) != null) max = Math.max(i - map.get(newNums[i]), max);
            if (newNums[i] == 0) max = Math.max(i, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
