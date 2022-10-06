/*
 * @lc app=leetcode.cn id=9 lang=c
 *
 * [9] 回文数
 */

// @lc code=start

bool isPalindrome(int x)
{
    int a[20];
    int num = 0;
    int temp = 1;
    if (x < 0)
    {
        return 0;
    }
    for (int i = 0; temp > 0; i++)
    {
        temp = x / (int)pow(10, i);
        a[i] = temp % 10;
        num++;
    }
    for (int i = 0; i < num / 2; i++)
    {
        if (a[i] == a[num - i - 2])
        {
        }
        else
        {
            return 0;
        }
    }
    return 1;
}
// @lc code=end
