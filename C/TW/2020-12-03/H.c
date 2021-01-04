#include <stdio.h>
int main(void)
{
    int n[100], m[100];
    int a[100][1000];
    int count = 0;
    for (int i = 0;; i++)
    {
        scanf("%d%d", &n[i], &m[i]);
        if (!n[i] && !m[i])
        {
            count = i;
            break;
        }
        for (int j = 0; j < n[i]; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }
    for (int k = 0; k < count; k++)
    {
        for (int i = 0; i < n[k]; i++)
        {
            if (a[k][i] >= m[k])
            {
                for (int j = 0; j < n[k] - i; j++)
                {
                    a[k][n[k] - j] = a[k][n[k] - j - 1];
                }
                a[k][i] = m[k];
                break;
            }
        }
        for (int i = 0; i < n[k] + 1; i++)
        {
            if (i == n[k])
            {
                printf("%d", a[k][i]);
            }
            else
            {
                printf("%d ", a[k][i]);
            }
        }
        printf("\n");
    }

    return 0;
}