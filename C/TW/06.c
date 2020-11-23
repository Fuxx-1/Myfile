#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int m = n + n - 1;
    int q = n;
    int t = 0;
    int a[n][n];
    int *p;
    p = &a[0][-1];
    for (int i = 0; i < (n + n - 1); i++)
    {
        if (m % 4 == 2)
        {
            for (int j = 1; j < q; j++)
            {
                p -= n;
                t += 1;
                *p = t;
            }
        }
        else if (m % 4 == 1)
        {
            for (int j = 1; j < q; j++)
            {
                p += 1;
                t += 1;
                *p = t;
            }
        }
        else if (m % 4 == 0)
        {
            for (int j = 1; j < q; j++)
            {
                p += n;
                t += 1;
                *p = t;
            }
        }
        else if (m % 4 == 3)
        {
            for (int j = 1; j < q; j++)
            {
                p -= 1;
                t += 1;
                *p = t;
            }
        }
        if (m % 2)
            q -= 1;
        m -= 1;
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            printf("%-5d", a[i][j]);
        }
        printf("\n");
    }

    system("pause");
    return 0;
}