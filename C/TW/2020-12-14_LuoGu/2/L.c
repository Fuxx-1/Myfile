#include <stdio.h>
int main(void)
{
    int t, n;
    scanf("%d", &t);
    for (int i = 0; i < t; i++)
    {
        scanf("%d", &n);
        if (n % 2)
        {
            printf("zs wins\n");
        }
        else
        {
            printf("pb wins\n");
        }
    }
    return 0;
}