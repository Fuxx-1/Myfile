#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int n = 0;
    scanf("%d", &n);
    int a[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    int q = 1;
    for (int i = 0; i < n - 1; i++)
    {
        if (a[1] - a[0] != 1)
        {
            printf("false\n");
            return 0;
        }
        int w = a[i + 1] - a[i];
        if (w <= (q + 2) && w >= (q - 2))
            q = w;
        else
        {
            printf("false\n");
            return 0;
        }
    }
    printf("true\n");
    system("pause");
    return 0;
}