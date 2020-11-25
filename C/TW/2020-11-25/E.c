#include <stdio.h>
int main(void)
{
    int n, t;
    unsigned int a[10000];
    for (int i = 0; 1 ; i++)
    {
        scanf("%d", &a[i]);
        if (!(a[i]))
        {
            n = i - 1;
            break;
        }
    }
    for (int i = n; i >= 0; i--)
    {
        printf("%d ", a[i]);
    }
    return 0;
}