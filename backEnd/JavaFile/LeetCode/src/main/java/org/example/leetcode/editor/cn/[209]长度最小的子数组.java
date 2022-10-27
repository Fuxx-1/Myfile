////给定一个含有 n 个正整数的数组和一个正整数 target 。
////
//// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
////度。如果不存在符合条件的子数组，返回 0 。
////
////
////
//// 示例 1：
////
////
////输入：target = 7, nums = [2,3,1,2,4,3]
////输出：2
////解释：子数组 [4,3] 是该条件下的长度最小的子数组。
////
////
//// 示例 2：
////
////
////输入：target = 4, nums = [1,4,4]
////输出：1
////
////
//// 示例 3：
////
////
////输入：target = 11, nums = [1,1,1,1,1,1,1,1]
////输出：0
////
////
////
////
//// 提示：
////
////
//// 1 <= target <= 10⁹
//// 1 <= nums.length <= 10⁵
//// 1 <= nums[i] <= 10⁵
////
////
////
////
//// 进阶：
////
////
//// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
////
////
//// Related Topics 数组 二分查找 前缀和 滑动窗口
//// 👍 1421 👎 0
//
//
//import java.util.Arrays;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//        public int minSubArrayLen(int target, int[] nums) {
//        int left = 0, sum = 0, minLength = 0;
//        for (int right = 0; right < nums.length; right++) {
//            sum += nums[right];
//            while (sum >= target) {
//                if (minLength == 0) {
//                    minLength = right - left + 1;
//                } else {
//                    minLength = Math.min(minLength, right - left + 1);
//                }
//                sum -= nums[left++];
//            }
//        }
//        return minLength;
//    }
//
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//class Test {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] nums = new int[6];
//        nums[0] = 10;
//        nums[1] = 12;
//        nums[2] = 1;
//        nums[3] = 2;
//        nums[4] = 4;
//        nums[5] = 3;
//        System.out.println(solution.minSubArrayLen(11, nums));
//    }
//}