/*
 * @lc app=leetcode.cn id=66 lang=c
 *
 * [66] 加一
 */

// @lc code=start

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int *plusOne(int *digits, int digitsSize, int *returnSize)
{
    for (int i = digitsSize - 1; i > -1; i++)
    {
        digits[i]++;
        digits[i] > 9 || (digits[i] -= 10 && 1) || digits[i - 1]++;
    }
    return digits;
}
// @lc code=end
