/* 
3、设int a=0,b=5;执行表达式++a||++b,a+b后，a,b和表达式的值分别是（）

a = 1
b = 5
 */
#include <stdio.h>
#include <stdlib.h>

int main (void)
{
    int a = 0, b = 5;
    ++a || ++b, a + b;
    printf("a = %d\nb = %d\n", a, b);

    system("pause");
    return 0;
}