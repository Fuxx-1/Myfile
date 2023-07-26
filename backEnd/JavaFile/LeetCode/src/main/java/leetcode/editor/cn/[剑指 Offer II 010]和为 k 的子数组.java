package leetcode.editor.cn;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int[] numsBak = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.parallelPrefix(numsBak, (x, y) -> x + y);
        for (int i = 0; i < numsBak.length; i++) {
            if (numsBak[i] == k) res++;
            for (int j = i + 1; j < numsBak.length; j++) {
                if (numsBak[j] - numsBak[i] == k) res++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
