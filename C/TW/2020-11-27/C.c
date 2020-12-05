#include <stdio.h>
int main(void)
{
    int n, k, count = 0;
    scanf("%d%d", &n, &k);
    int a[10000];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    int j = 0, m = 0;
    for (int i = 0; i < n / 2 + n % 2; i++)
    {
        if (j != 1 && a[i] <= k)
            count++;
        else
            j = 1;
        if (m != 1 && i != n - i - 1 && a[n - i - 1] <= k)
            count++;
        else
            m = 1;
    }
    printf("%d\n", count);
    return 0;
}