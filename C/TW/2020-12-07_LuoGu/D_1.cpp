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
    for (int i = 0; i < m; i++)
    {
        temp = std::lower_bound(a, a + n, b[i]);
        mid = temp - &a[0];
        if (std::binary_search(a, a + n, b[i]))
            printf("%d ", mid + 1);
        else if (a[0] == 0 && b[i] == 0)
            printf("1");
        else
            printf("-1 ");
    }
    return 0;
}