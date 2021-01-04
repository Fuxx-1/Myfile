#include <stdio.h>
int main(void)
{
    long long int t, n, m, k;
    long long int a[101];
    long long int b[1000];
    scanf("%lld", &t);
    for (int j = 0; j < t; j++)
    {
        scanf("%lld%lld%lld", &n, &m, &k);
        for (int i = 0; i < n; i++)
        {
            scanf("%lld", &a[i]);
        }
        for (int i = 0; i < n; i++)
        {
            if (i + 1 == n)
            {
                b[j] = 1;
                break;
            }
            if (a[i] + k >= a[i + 1])
            {
                if (a[i] + k - a[i + 1] <= a[i])
                {
                    m += (a[i] + k - a[i + 1]);
                }
                else
                {
                    m += a[i];
                }
                
            }
            else if (a[i] + k + m >= a[i + 1])
            {
                m -= a[i + 1] - k - a[i];
            }
            else if (a[i] + k < a[i + 1])
            {
                b[j] = 0;
                break;
            }
        }
    }
    for (int i = 0; i < t; i++)
    {
        if (b[i])
        {
            printf("YES\n");
        }
        else
        {
            printf("NO\n");
        }
    }
    return 0;
}