#include <stdio.h>
int main(void)
{
    int n;
    int value = 1;
    int i, j;
    scanf("%d", &n);
    int m[100][100];
    for (i = 0; i < (n + 1) / 2; i++)
    {
        for (j = i; j < n - i; j++)
        {
            m[i][j] = value++;
        }

        for (j = i + 1; j < n - i; j++)
        {
            m[j][n - i - 1] = value++;
        }
        for (j = n - i - 2; j >= i; j--)
        {
            m[n - i - 1][j] = value++;
        }
        for (j = n - i - 2; j > i; j--)
        {
            m[j][i] = value++;
        }
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            printf("%5d", m[i][j]);
        }
        printf("\n");
    }

    return 0;
}