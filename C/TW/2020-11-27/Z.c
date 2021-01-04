#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[10000][2];
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d", &a[i][0], &a[i][1]);
    }
    for (int i = 0; i < n; i++)
    {
        printf("%d\n", a[i][0] + a[i][1]);
    }
    return 0;
}