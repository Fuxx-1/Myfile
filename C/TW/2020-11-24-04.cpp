#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int n = 0;
    while (1)
    {
        scanf("%d", &n);
        if (n)
        {
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
        else
            break;
    }
    system("pause");
    return 0;
}