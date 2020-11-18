#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int a[10000];
    for (int i = 0; i + 1; i++)
    {
        scanf("%d", &a[i]);
    }
    
    int n = sizeof(a) / sizeof(a[0]);
    for (int i = 0; i < n - 1; i++)
    {
        for (int e = 0; e < n - 1 - i; e++)
            if (a[e] < a[e + 1])
            {
                int temp;
                temp = a[e + 1];
                a[e + 1] = a[e];
                a[e] = temp;
            }
    }

    for (int u = 0; u <= n; u++)
        printf("%d\n", a[u]);

    system("pause");
    return 0;
}