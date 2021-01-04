#include <stdio.h>
#include <algorithm>
int main(void)
{
    long long t, n, k, sum;
    scanf("%lld", &t);
    long long a[200000];
    long long b[1000];
    for (int i = 0; i < t; i++)
    {
        sum = 0;
        scanf("%lld%lld", &n, &k);
        for (int j = 0; j < n; j++)
        {
            scanf("%lld", &a[j]);
        }
        std::sort(a, a + n);
        sum = a[n - 1];
        for (int j = 0; j < k; j++)
        {
            sum += a[n - j - 2];
        }
        if (!k)
        {
            b[i] = sum - a[0];
        }
        else
        {
            b[i] = sum;
        }
    }
    for (int i = 0; i < t; i++)
    {
        printf("%lld\n", b[i]);
    }
    return 0;
}