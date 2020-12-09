#include <stdio.h>
#include <algorithm>
int main(void)
{
    int n, s, a, b;
    scanf("%d%d%d%d", &n, &s, &a, &b);
    int x[300], y[150];
    int dp[300][150];
    int count = 0;
    for (int i = 1; i <= n; i++)
    {
        scanf("%d%d", &x[i], &y[i]);
    }
    for (int i = 1; i <= n; i++)
    {
        if (x[i] > a + b || (x[i] < a - b && x[i] > b))
        {
            for (int j = i; j <= n; j++)
            {
                x[j] = x[j + 1];
                y[j] = y[j + 1];
            }
            count++;
        }
    }
    for (int i = 1; i <= n - count; i++)
    {
        for (int j = s; j >= 0; j--)
        {
            if (j >= y[i])
            {
                dp[i][j] = std::max(dp[i - 1][j - y[i]] + 1, dp[i - 1][j]);
            }
            else
            {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    printf("%d\n", dp[n - count][s]);
    return 0;
}