#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct a
{
} b;

void A(int length)
{
    static int B = sizeof(b);
    if (length)
        printf("%d\n", B);
    else
        B--, A(length - 1);
}
int main(const int length, const char *args[])
{
    A(length - 1);

    system("pause");
    return 0;
}