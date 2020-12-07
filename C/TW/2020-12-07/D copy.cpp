#include <stdio.h>
#include <algorithm>
int a[1000000];
int main(void)
{
    int n, m;
    scanf("%d%d", &n, &m);
    int b[100000];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < m; i++)
    {
        scanf("%d", &b[i]);
    }
    int mid;
    int *temp;
    std::sort(a, a + 1000000);
    for (int i = 0; i < m; i++)
    {
        temp = std::lower_bound(a, a + 1000000, b[i]);
        mid = temp - &a[0];
        if (*temp == b[i])
            printf("%d ", mid + 1 - 1000000 + n);
        else
            printf("-1 ");
    }
    return 0;
}