#include <stdio.h>
int main(void)
{
    int m, b, x, t;
    long int a[10000];
    for (int i = 0;; i++)
    {
        scanf("%d", &a[i]);
        if (!a[i])
            break;
    }
    for (int i = 0;; i++)
    {
        if (!a[i])
        {
            break;
        }
        b = 10;
        while (b > 9)
        {
            b = 0;
            m = 1;
            for (int j = 0; j < 100; j++)
            {
                t = a[i] / m;
                x = t % 10;
                b += x;
                m *= 10;
                if (!t)
                    break;
            }
            a[i] = b;
        }
        printf("%d\n", b);
    }
    return 0;
}