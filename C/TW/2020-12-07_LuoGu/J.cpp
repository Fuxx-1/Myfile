#include <stdio.h>
#include <algorithm>
int main()
{
    int w[110], val[110];
    int dp[110][110];
    int t, m, res = -1;
    scanf("%d%d", &t, &m);
    for (int i = 1; i <= m; i++)
    {
        scanf("%d%d", &w[i], &val[i]);
    }
    for (int i = 1; i <= m; i++)
    {
        for (int j = t; j >= 0; j--)
        {
            if (j >= w[i])
            {
                dp[i][j] = std::max(dp[i - 1][j - w[i]] + val[i], dp[i - 1][j]);
            }
            else
            {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    printf("%d", dp[m][t]);
    return 0;
}