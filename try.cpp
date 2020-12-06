#include <stdio.h>
int main(void)
{
    int a[30];
    int n = 1;
    for (int i = 0; i < 30; i++)
    {
        a[i] = n;
        n *= 2;
        printf("%d, ", a[i]);
    }
    return 0;
}