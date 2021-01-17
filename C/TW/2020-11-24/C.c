#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int a, b;
    while (scanf("%d%d", &a, &b) != EOF)
    {
        if (a || b)
            printf("%d\n", a + b);
        else
            break;
    }
    return 0;
}