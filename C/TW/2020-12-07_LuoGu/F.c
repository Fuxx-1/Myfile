#include <stdio.h>
int main(void)
{
    long long int n, x;
    long long int a[100010];
    long long int val = 0;
    scanf("%lld%lld", &n, &x);
    for (int i = 0; i < n; i++)
    {
        scanf("%lld", &a[i]);
    }
    for (int i = 0; i < n - 1; i++)
    {
        if (a[i] + a[i + 1] > x)
        {
            val += a[i] + a[i + 1] - x;
            if (a[i] + a[i + 1] - x < a[i + 1])
            {
                a[i + 1] -= a[i] + a[i + 1] - x;
            }
            else
            {
                a[i + 1] = 0;
                a[i] -= a[i] - a[i + 1] - x;
            }
        }
    }
    printf("%lld", val);
    return 0;
}