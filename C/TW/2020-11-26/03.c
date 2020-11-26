#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[n + 2][7];
    int count;
    for (int i = 0; i < n + 1; i++)
    {
        for (int j = 0; j < 7; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }
    for (int i = 0; i < 7; i++)
    {
        a[n + 1][i] = 0;
    }
    for (int i = 1; i < n + 1; i++)
    {
        count = 0;
        for (int j = 0; j < 7; j++)
        {
            for (int k = 0; k < 7; k++)
            {
                if (a[i][j] == a[0][k])
                {
                    count++;
                }
            }
        }
        a[n + 1][7 - count]++;
    }
    for (int i = 0; i < 7; i++)
    {
        printf("%d", a[n + 1][i]);
        if (i != 6)
        {
            printf(" ");
        }
    }
    return 0;
}