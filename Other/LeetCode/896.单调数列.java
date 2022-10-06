/*
 * @lc app=leetcode.cn id=896 lang=java
 *
 * [896] 单调数列
 */

// @lc code=start
class Solution {
    public boolean isMonotonic(int[] A) {
        for (int i = 0; i < A.length - 1;i++) {
            if (A[i] <= A[i + 1] && i == A.length - 2) {
                return true;
            } else if (A[i] > A[i + 1]) {
                break;
            }
        }
        for (int i = 0; i < A.length - 1;i++) {
            if (A[i] >= A[i + 1] && i == A.length - 2) {
                return true;
            } else if (A[i] < A[i + 1]) {
                break;
            }
        }
        if (A.length ==1) {
            return true;
        } else {
            return false;
        }
    }
}
// @lc code=end

