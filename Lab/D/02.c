#include <stdio.h>
#include <stdlib.h>

int main()
{

    int a, b, c, d;
    a = 10;
    b = a++;
    c = ++a;
    d = 10 * a++;
    printf("b,c,d: %d,%d,%d", b, c, d); //10, 12, 120

    system("pause");
    return 0;
}