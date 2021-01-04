#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int a, b, c, x, y, z;
    scanf("%d%d%d", &a, &b, &c);
    if (a > b)
    {
        x = a;
        a = b;
        b = x;
    }
    if (b > c)
    {
        y = b;
        b = c;
        c = y;
    }
    if (a > b)
    {
        x = a;
        a = b;
        b = x;
    }
    if (b > c)
    {
        y = b;
        b = c;
        c = y;
    }
    printf("%d%d%d\n", a, b, c);

    system("pause");
    return 0;
}