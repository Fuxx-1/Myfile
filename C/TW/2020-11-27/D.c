#include <stdio.h>
int main(void)
{
    int n, max = 0, val = 0;
    scanf("%d", &n);
    int a[10000][2];
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d", &a[i][0], &a[i][1]);
    }
    for (int i = 0; i < n; i++)
    {
        val -= a[i][0];
        val += a[i][1];
        if (max < val)
        {
            max = val;
        }
    }
    printf("%d", max);
    return 0;
}