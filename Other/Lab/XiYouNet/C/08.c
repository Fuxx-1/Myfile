#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int a[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    printf("%d\n", a[2]);
    printf("%d\n", (int *)(a + 4));
    printf("%d\n", &a[3]);
    printf("%d\n", *(a + 2));
    system("pause");
    return 0;
}