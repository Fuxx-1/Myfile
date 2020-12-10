#include <stdio.h>
#include <algorithm>
int main(void)
{
    int x[50000], y[50000];
    int n, s, a, b;
    int ans = 0;
    scanf("%d%d%d%d", &n, &s, &a, &b);
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d", &x[i], &y[i]);
    }
    for (int i = 1; i <= n; i++)
    {
        if (x[i] > a + b || (x[i] < a && x[i] > b))
        {
            for (int j = i; j <= n; j++)
            {
                x[j] = x[j + 1];
                y[j] = y[j + 1];
            }
            count++;
            i--;
        }
    }
    std::sort(y, y + n - count);
    for (int i = 0; i < n - count + 1; i++)
    {
        if (s > y[i])
        {
            s -= y[i];
            ans++;
        }
        else
        {
            break;
        }
    }
    printf("%d\n", ans);
    return 0;
}