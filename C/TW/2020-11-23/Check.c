#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int a[2][2];
    int *p;
    p = &a[0][0];

    printf("%p\n", p);
    printf("%p\n", &a[0][0]);    

    p = p + 2;

    printf("%p\n", p);
    printf("%p\n", &a[1][0]);
    
    p = p - 2;

    printf("%p\n", p);
    printf("%p\n", &a[0][0]);

    system("pause");    
    return 0;
}