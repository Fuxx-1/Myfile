////给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
////。
////
//// 返回 滑动窗口中的最大值 。
////
////
////
//// 示例 1：
////
////
////输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
////输出：[3,3,5,5,6,7]
////解释：
////滑动窗口的位置                最大值
////---------------               -----
////[1  3  -1] -3  5  3  6  7       3
//// 1 [3  -1  -3] 5  3  6  7       3
//// 1  3 [-1  -3  5] 3  6  7       5
//// 1  3  -1 [-3  5  3] 6  7       5
//// 1  3  -1  -3 [5  3  6] 7       6
//// 1  3  -1  -3  5 [3  6  7]      7
////
////
//// 示例 2：
////
////
////输入：nums = [1], k = 1
////输出：[1]
////
////
////
////
//// 提示：
////
////
//// 1 <= nums.length <= 10⁵
//// -10⁴ <= nums[i] <= 10⁴
//// 1 <= k <= nums.length
////
////
//// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列）
//// 👍 1928 👎 0
//
//
//import java.util.Arrays;
//import java.util.Deque;
//import java.util.LinkedList;
//
////leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        Deque<Integer> deque = new LinkedList<>();
//        int left = 0;
//        int[] result = new int[nums.length - k + 1];
//        for (int i = 0; i < k; i++) {
//            if (deque.size() == 0) {
//                deque.addFirst(nums[i]);
//            } else {
//                while (deque.size() != 0 && deque.getFirst() < nums[i]) {
//                    deque.removeFirst();
//                }
//                deque.addFirst(nums[i]);
//            }
//        }
//        result[0] = deque.getLast();
//        for (int right = k; right < nums.length; right++) {
//            while (deque.size() != 0 && deque.getFirst() < nums[right]) {
//                deque.removeFirst();
//            }
//            deque.addFirst(nums[right]);
//            if (deque.getLast() == nums[left++]) {
//                deque.removeLast();
//            }
//            result[right - k + 1] = deque.getLast();
//        }
//        return result;
//    }
//}
////leetcode submit region end(Prohibit modification and deletion)
//
//class Test {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] ints = new int[6];
//        ints[0] = 1;
//        ints[1] = 3;
//        ints[2] = 1;
//        ints[3] = 2;
//        ints[4] = 0;
//        ints[5] = 5;
//        System.out.println(Arrays.toString(solution.maxSlidingWindow(ints, 3)));
//    }
//}