#include <stdio.h>
#include <algorithm>
long long int b[10000];
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[100000];
    long long int count = 0;
    for (int i = 0; i < n; i++)
    {
        scanf("%lld", &a[i]);
        b[a[i]]++;
    }
    std::sort(a, a + n);
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (b[a[i] + a[j]] >= 2 && i != j)
            {
                if (count >= 1000000007)
                {
                    count -= 1000000007;
                }
                count++;
            }
        }
    }
    printf("%lld", count);
    return 0;
}