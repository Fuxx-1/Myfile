#include <stdio.h>
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
    int low, high, mid;
    int i = 0;
    while (m--)
    {
        low = 1, high = n;
        while (low < high)
        {
            mid = low + (high - 1) / 2;
            if (a[mid] >= b[i])
            {
                high = mid;
            }
            else
            {
                low = mid + 1;
            }
        }
        if (!(a[mid] - b[i]))
        {
            printf("%d ", mid + 1);
        }
        else
        {
            printf("-1 ");
        }
        i++;
    }
    return 0;
}