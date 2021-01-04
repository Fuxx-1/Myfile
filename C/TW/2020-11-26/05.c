#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[1000];
    int count = 0;
    while (n != 1)
    {
        a[count] = n;
        if (n % 2)
        {
            n = 3 * n + 1;
        }
        else if (!(n % 2))
        {
            n = n / 2;
        }
        count++;
    }
    a[count] = n;
    for (int i = count; i >= 0; i--)
    {
        printf("%d", a[i]);
        if (i != 0)
        {
            printf(" ");
        }
    }

    return 0;
}