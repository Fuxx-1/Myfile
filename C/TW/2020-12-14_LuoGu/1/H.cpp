#include <stdio.h>
#include <algorithm>
int a[1000005];
int main(void)
{
    int n, k, ans = 0;
    scanf("%d%d", &n, &k);
    for (int i = 0; i < n; ++i)
    {
        if (std::__gcd(i, n) == 1)
        {
            a[ans++] = i;
        }
    }
    printf("%d", (k - 1) / ans * n + a[(k - 1) % ans]);
    return 0;
}