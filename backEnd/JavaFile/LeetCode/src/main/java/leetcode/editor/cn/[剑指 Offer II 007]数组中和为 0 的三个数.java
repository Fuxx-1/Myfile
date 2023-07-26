package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int left = -1, mid, right;
        List<List<Integer>> res = new ArrayList<>();
        while (++left <= nums.length - 3) {
            while (left != 0 && left <= nums.length - 3 && nums[left] == nums[left - 1]) left++;
            mid = left + 1;
            right = nums.length - 1;
            while (mid < right) {
                if (nums[mid] + nums[right] + nums[left] == 0) {
                    res.add(Arrays.asList(nums[left], nums[mid++], nums[right]));
                    while (mid < right && nums[mid] == nums[mid - 1]) mid++;
                }
                if (nums[mid] + nums[right] + nums[left] < 0) mid++;
                if (nums[mid] + nums[right] + nums[left] > 0) right--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
