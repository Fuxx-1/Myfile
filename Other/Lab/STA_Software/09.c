#include "stdio.h"
#include <stdlib.h>
int main()
{
    int a[5] = {1, 2, 3, 4, 5};
    int *p = (int *)(&a + 1);
    printf("%d,%d,%d\n", *(a + 1), *(p - 1), *p);
    printf("%p\n", p - 1);
    printf("%p\n", p);
    printf("%p\n", a + 1);
    system("pause");
    return 0;
}