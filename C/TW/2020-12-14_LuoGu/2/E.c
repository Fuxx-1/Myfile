#include <stdio.h>
char a[10000000];
char b[6000000];
int main(void)
{
    int m, n, num;
    scanf("%d%d", &m, &n);
    num = n;
    char bin = getchar();
    scanf("%s", a);
    scanf("%s", b);
    /* 处理 */
    while (n--)
    {
        /* 加法 */
        if (b[num - n - 1] == '+')
        {
            int x = m - 1;
            a[m - 1]++;
            while (a[x] == '2')
            {
                a[x] = '0';
                a[--x]++;
            }
        }
        /* 减法 */
        if (b[num - n - 1] == '-')
        {
            int x = m - 1;
            a[m - 1]--;
            while (a[x] == '0' - 1)
            {
                a[x] = '1';
                a[--x]--;
            }
        }
        /* 乘除法 */
        if (b[num - n - 1] == '*')
        {
            int x = m++;
            a[x++] = '0';
            a[x] = 0;
        }
        if (b[num - n - 1] == '/')
        {
            int x = --m;
            a[x] = 0;
        }
    }
    /* 输出 */
    printf("%s\n", a);
    return 0;
}