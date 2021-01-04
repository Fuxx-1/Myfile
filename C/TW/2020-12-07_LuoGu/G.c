#include <stdio.h>
int main(void)
{
    int n, m;
    scanf("%d%d", &n, &m);
    char ch = getchar();
    char str[1000][1000];
    for (int i = 0; i < n; i++)
    {
        gets(&str[i][0]);
    }
    char *p;
    p = &str[0][0];
    int temp;
    for (int i = 0; i < n; i++)
    {
        for (int i = 0; i < m; i++)
        {
            temp = 0;
            if (*p == '*')
            {
                p++;
                continue;
            }
            else
                *p = '0';
            if (*(p + 1) == '*')
                temp++;
            if (*(p - 1) == '*')
                temp++;
            if (*(p + 999) == '*')
                temp++;
            if (*(p + 1000) == '*')
                temp++;
            if (*(p + 1001) == '*')
                temp++;
            if (*(p - 999) == '*')
                temp++;
            if (*(p - 1000) == '*')
                temp++;
            if (*(p - 1001) == '*')
                temp++;
            *p = temp + '0';
            p++;
        }
        p += 1000 - m;
    }
    for (int i = 0; i < n; i++)
    {
        puts(&str[i][0]);
    }
    return 0;
}