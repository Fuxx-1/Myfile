#include <stdio.h>
#include <stdlib.h>
static int j;
void fun1(void)
{
    static int i = 0;
    i++;
}
void fun2(void)
{
    j = 0;
    j++;
}
int main()
{
    int k = 1;
    for (k = 0; k <= 10; k++)
    {
        fun1();
        fun2();
        printf("%d\n", k);
    }
    //printf("%d\n", i);
    printf("%d\n", j);
    printf("%d\n", k);
    system("pause");
    return 0;
}