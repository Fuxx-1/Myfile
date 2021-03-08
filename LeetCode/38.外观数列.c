/*
 * @lc app=leetcode.cn id=38 lang=c
 *
 * [38] 外观数列
 */

// @lc code=start

char *countAndSay(int n)
{
    char a[1000];
    a[0] = 1;
    for (int i = 0; i < n - 1; i++)
    {
        int *p = &a[0];
        int count = 1, val = 0;
        while (*p != 0)
        {
            if (*p = *(p + 1))
            {
                count++;
                p++;
            }
            else
            {
                a[val++] = count;
                a[val++] = *(p);
                count = 0;
            }
        }
    }
    return a;
}
// @lc code=end
