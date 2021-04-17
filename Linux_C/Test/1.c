#include <stdio.h>
int t[1005], dp[1005][1005], v[1005];
int max(int a, int b);
int main()
{
    int time, n, i, j;
    scanf("%d %d", &time, &n);
    for (i = 1; i <= n; i++)
    {
        scanf("%d %d", &t[i], &v[i]);
    }
    for (i = 1; i <= n; i++)
    {
        for (j = time; j >= 0; j--)
        {
            if (j >= t[i])
            {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - t[i]] + v[i]);
            }
            else
            {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    printf("%d\n", dp[n][time]);
    return 0;
}
int max(int a, int b)
{
    return a > b ? a : b;
}