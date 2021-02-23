#include <stdio.h>
int main()
{
    int a[57] = {0, 1, 2, 3, 4};
    int n, i;
    for (i = 5; i < 57; i++)
    {
        a[i] = a[i - 1] + a[i - 3];
    }
    while (scanf("%d", &n) != EOF)
    {
        if (n == 0)
            break;
        printf("%d\n", a[n]);
    }
    return 0;
}