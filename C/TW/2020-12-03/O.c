#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[10000];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < n; i++)
    {
        printf("%d\n", 3 * a[i] * a[i] - 3 * a[i] + 2);
    }
    return 0;
}