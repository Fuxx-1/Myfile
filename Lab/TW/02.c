#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a = 5, b = 7;
    a = a^b;
    b = b^a;
    a = a^b;
    printf("aÎª£º%d\nbÎª£º%d\n", a, b);

    system("pause");
    return 0;
}