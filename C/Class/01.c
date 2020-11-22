#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int x, y;
    scanf("%d%d", &x, &y);
    // swap(&x, &y);
    x = x + y;
    y = x - y;
    x = x - y;
    printf("%d%d", x, y);

    system("pause");
    return 0;
}