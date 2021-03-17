/*
 * @lc app=leetcode.cn id=13 lang=c
 *
 * [13] 罗马数字转整数
 */

// @lc code=start

int romanToInt(char *s)
{
    int ans = 0;
    int length = strlen(s);
    for (int i = 0; i < length; i++)
    {
        switch (s[i])
        {
        case 'M':
            ans += 1000;
            break;
        case 'D':
            ans += 500;
            break;
        case 'C':
            if (s[i + 1] == 'D' || s[i + 1] == 'M')
            {
                ans -= 200;
            }
            ans += 100;
            break;
        case 'L':
            ans += 50;
            break;
        case 'X':
            if (s[i + 1] == 'L' || s[i + 1] == 'C')
            {
                ans -= 20;
            }
            ans += 10;
            break;
        case 'V':
            ans += 5;
            break;
        case 'I':
            if (s[i + 1] == 'V' || s[i + 1] == 'X')
            {
                ans -= 2;
            }
            ans += 1;
            break;
        default:
            break;
        }
    }
    return ans;
}
// @lc code=end
