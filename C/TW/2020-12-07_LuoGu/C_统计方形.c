#include <stdio.h>
int main(void)
{
    long long int n, m;
    scanf("%lld%lld", &n, &m);
    long long int ans1, ans2;
    for (int i = 0; i < (m > n ? n : m); i++)
    {
        ans1 += (n - i) * (m - i);
    }
    ans2 = ((n * n + n) / 2) * ((m * m + m) / 2);
    printf("%lld %lld", ans1, ans2 - ans1);
    return 0;
}