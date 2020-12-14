#include <stdio.h>
#include <string.h>
#include <algorithm>
void swap(char *p, char b, char c, int n)
{
    for (int i = 0; i < n; i++)
    {
        if (*p == b)
        {
            *p = c;
        }
        p++;
    }
    return;
}
int main(void)
{
    int t, count, ans, count1, count2, count3;
    char s[15];
    scanf("%d", &t);
    for (int j = 0; j < t; j++)
    {
        count = count1 = count2 = count3 = 0;
        char bin = getchar();
        gets(s);
        int n = strlen(s);
        n--;
        swap(&s[0], '3', 'A', n);
        swap(&s[0], '4', 'B', n);
        swap(&s[0], '5', 'C', n);
        swap(&s[0], '6', 'D', n);
        swap(&s[0], '7', 'E', n);
        swap(&s[0], '8', 'F', n);
        swap(&s[0], '9', 'G', n);
        swap(&s[0], '0', 'H', n);
        swap(&s[0], 'J', 'I', n);
        swap(&s[0], 'Q', 'J', n);
        swap(&s[0], 'K', 'K', n);
        swap(&s[0], 'A', 'L', n);
        swap(&s[0], '2', 'M', n);
        std::sort(s, s + n);
        ans = n;
        for (int i = 0; i < n; i++)
        {
            if (s[i] == s[i + 1] - 1 && s[i + 1] != 'M')
            {
                count3++;
            }
        }
        if (count3 >= 4)
        {
            ans += count3;
        }
        for (int i = 0; i < n; i++)
        {
            if (s[i] == s[i + 1] && s[i + 1] == s[i + 2] && s[i + 2] == s[i + 3])
            {
                count2++;
            }
        }
        for (int i = 0; i < n; i++)
        {
            if (s[i] == s[i + 1] && s[i + 1] != s[i + 2])
            {
                count1++;
            }
        }
        count1 -= count2;
        for (int i = 0; i < n; i++)
        {
            if (s[i] == s[i + 1])
            {
                count++;
            }
        }
        count -= count1;
        ans += count2;
        ans += count1;
        ans += count;
        if (count2 && count3)
        {
            ans += count2 - count3 > count3 - count2 ? count2 - count3 : count3 - count2;
        }
        printf("%d\n", ans);
    }
    return 0;
}