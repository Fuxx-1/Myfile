/*
 * @lc app=leetcode.cn id=38 lang=c
 *
 * [38] 外观数列
 */

// @lc code=start

char *countAndSay(int n)
{
    char a[1000];
    int count, val;
    for (int i = 0; i < n - 1; i++)
    {
        count = 1, val = 0;
        char *p = &a[0];
        a[0] = 1;
        while (*p)
        {
            if (*p == *(p + 1))
            {
                count++;
            }
            else
            {
                a[val++] = count;
            }
            p++;
        }
    }
}
// @lc code=end
