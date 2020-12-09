#include <stdio.h>
#include <algorithm>
int a[40000];
int main(void)
{
    int n, max;
    scanf("%d%d", &max, &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    std::sort(a, a + n);
    int l, r, count = 0;
    l = 0, r = n - 1;
    while(l <= r)
    {
        if (a[l] + a[r] <= max)
        {
            l++, r--;
            count++;
        }
        else if (a[r] <= max)
        {
            r--;
            count++;
        }
    }
    printf("%d", count);
    return 0;
}