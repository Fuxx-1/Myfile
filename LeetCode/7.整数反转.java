/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        long y = x;
        return (int)(y > 0 ? (Long.parseLong(new StringBuffer(String.valueOf(y)).reverse().toString()) > 2147483647 ? 0 : Long.parseLong(new StringBuffer(String.valueOf(y).toString()).reverse().toString())) : (-Long.parseLong(new StringBuffer(String.valueOf(-y).toString()).reverse().toString()) < -2147483648 ? 0 : -Long.parseLong(new StringBuffer(String.valueOf(-y).toString()).reverse().toString())));
    }
}
// @lc code=end

