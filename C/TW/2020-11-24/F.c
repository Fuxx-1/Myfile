#include <stdio.h>
int main(void)
{
    int n, m = 0;
    int a[10000];
    while (scanf("%d", &n) != EOF)
    {
        for (int i = 0; i < n; i++)
        {
            scanf("%d", &a[i]);
        }
        for (int i = 1; i < n; i++)
        {
            a[0] += a[i];
        }
        printf("%d\n", a[0]);
    }
    return 0;
}