#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int m = n + n - 1;
    int q = n - 1;
    int t = 1;
    int a[n][n];
    int *p;
    p = &a[0][0];
    int time = 1;
    for (int i = 0; i < (n + n - 1); i++)
    {
        if (time % 4 == 1)
        {
            for (int j = 0; j < q; j++)
            {
                *p = t;
                p += 1;
                t += 1;
                *p = t;
                printf("%p\n", p);
            }
        }
        else if (time % 4 == 2)
        {
            for (int j = 0; j < q; j++)
            {
                *p = t;
                p += n;
                t += 1;
                *p = t;
                printf("%p\n", p);
            }
        }
        else if (time % 4 == 3)
        {
            for (int j = 0; j < q; j++)
            {
                *p = t;
                p -= 1;
                t += 1;
                *p = t;
                printf("%p\n", p);
            }
        }
        else if (time % 4 == 0)
        {
            for (int j = 0; j < q; j++)
            {
                *p = t;
                p -= n;
                t += 1;
                *p = t;
                printf("%p\n", p);
            }
        }

        if ((m % 2 == 1)&& time != 1)
            q -= 1;
        time += 1;
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            printf("%-10d", a[i][j]);
        }
        printf("\n");
    }

    system("pause");
    return 0;
}