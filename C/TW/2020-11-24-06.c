#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    while (scanf("%d", &n) != EOF)
    {
        int n = 0;
        int a[10];
        for (int i = 0; i < n; ++i)
        {
            scanf("%d", &a[i]);
            if (i > 1)
            {
                a[0] += a[i];
            }
        }
        printf("%d\n", a[0]);
    }
    system("pause");
    return 0;
}