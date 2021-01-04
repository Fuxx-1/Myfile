#include <stdio.h>
#include <stdlib.h>
int main()
{
    int i = 0;
loop:
    printf("I am come again!\n");
    i++;
    if (i >= 0)
        goto loop;
    system("pause");
    return 0;
}