#include <stdio.h>
#include <algorithm>
int main(void)
{
    int m, sum;
    scanf("%d", &m);
    int a[50][500];
    int n[50];
    int k[50];
    int b[500];
    for (int i = 0; i < m; i++)
    {
        scanf("%d%d", &n[i], &k[i]);
        for (int j = 0; j < n[i]; j++)
        {
            scanf("%d", &a[i][j]);
        }
    }
    for (int i = 0; i < m; i++)
    {
        sum = 0;
        for (int j = 0; j < n[i]; j++)
        {
            b[j] = a[i][j];
        }
        int d = n[i];
        std::sort(b, b + d);
        for (int j = 0; j <= k[i]; j++)
        {
            int d = n[i] - 1 - j;
            sum += b[d];
        }
        printf("%d\n", sum);
    }
    return 0;
}