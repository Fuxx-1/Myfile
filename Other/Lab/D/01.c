#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    char str[] = "Hello";
    char *p = str;
    int n = 10;

    printf("%d\n", sizeof(str)); //6
    printf("%d\n", sizeof(p));   //4
    printf("%d\n", sizeof(n));   //4

    system("pause");
    return 0;
}
