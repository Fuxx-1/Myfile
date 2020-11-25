#include <stdio.h>
int main()
{
    int a[100];
    int m = 0, n = 0, t = 0, x = 0, i = 0;
    scanf("%d%d", &m, &n);
    if (m == 0 || n == 0)
        printf("%d", t);
    else
    {
        for (i = 0; i < m; i++)
        {
            scanf("%d", &a[i]);
        }
        for (int b = 0; b < n; b++)
        {
            t += a[b];
        }
        for (int j = 0; j < m - n + 1; j++)
        {
            x = 0;
            for (int c = j; c < n + j; c++)
            {
                x += a[c];
            }
            if (x <= t)
            {
                t = x;
            }
        }
        printf("%d", t);
    }
    return 0;
}
