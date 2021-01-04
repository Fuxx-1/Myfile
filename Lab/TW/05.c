#define _SWAP(a, b) \
    {               \
        int _T = a; \
        a = b;      \
        b = _T;     \
    }

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    int a = 1, b = 2;
    printf("%d %d\n", a, b);
    _SWAP(a, b);
    printf("%d %d\n", a, b);

    system("pause");
    return 0;
}