#include <stdio.h>
int main(void)
{
    int n, count = 0;
    scanf("%d", &n);
    int a[1000][3];
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d%d", &a[i][0], &a[i][1], &a[i][2]);
        a[i][0] = a[i][0] + a[i][1] + a[i][2];
    }
    for (int i = 0; i < n; i++)
    {
        if (a[i][0] >= 2)
        {
            count++;
        }
    }
    printf("%d", count);
    return 0;
}