#include <stdio.h>
#include <algorithm>
int main(void)
{
    int t;
    scanf("%d", &t);
    int n, k, max = 0;
    int a[100000];
    for (int l = 0; l < t; l++)
    {
        max = 0;
        scanf("%d%d", &n, &k);
        for (int i = 0; i < n; i++)
        {
            scanf("%d", &a[i]);
        }
        std::sort(a, a + n);
        for (int i = 0; i < n; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                if (a[j] - a[i] <= k)
                {
                    max = max > j - i ? max : j - i + 1;                    
                }
            }
        }
        printf("%d\n", max);
    }
    return 0;
}