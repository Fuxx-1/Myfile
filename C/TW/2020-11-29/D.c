#include <stdio.h>
int main(void)
{
    long long n, ans;
    scanf("%lld", &n);
    while (n--)
    {
        scanf("%lld", &ans);
        printf("%lld\n", ans - 1);
    }
    return 0;
}

