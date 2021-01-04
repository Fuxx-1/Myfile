#include <stdio.h>
int a[31][31];
int main(void)
{
    int count = 1;
    a[0][0] = a[1][0] = a[1][1] = 1;
    for (int i = 0; i < 30; i++)
    {
        for (int j = 0; j < count; j++)
        {
            if (i != 0 && i != 1)
            {
                a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
            }
        }
        count++;
    }
    int n;
    int m = 1;
    while (scanf("%d", &n) != EOF)
    {
        if (m != 1)
        {
            printf("\n");
            printf("\n");
        }
        count = 1;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < count; j++)
            {
                printf("%d", a[i][j]);
                if (i - 1 != count)
                {
                    printf(" ");
                }
            }
            if (i + 1 != n)
                printf("\n");
            count++;
        }
        m++;
    }
    return 0;
}
