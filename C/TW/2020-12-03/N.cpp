#include <stdio.h>
#include <algorithm>
int main(void)
{
    int n, t, count = 0;
    scanf("%d", &n);
    int a[50000], b[50000];
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d", &a[i], &b[i]);
    }
    std::sort(a, a + n);
    std::sort(b, b + n);
    for (int i = 1; i < n; i++)
    {
        if (a[i] <= b[i - 1])
        {
            count++;
        }
    }
    if (count == n - 1)
    {
        printf("%d %d\n", a[0], b[n - 1]);
    }
    else
    {
        printf("no\n");
    }
    return 0;
}

