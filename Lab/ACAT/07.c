/* 
7.下面是一个交换两个变量的函数，看看这种方法可以实现吗？如果可以，还有其他方法吗？如果不可以，说说原因，再想想可行的方法吧！
 */
void swap_1(int a, int b)
{
    int temp = a;
    a = b;
    b = temp;
}
void swap_2(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int a = 1, b = 2;
    printf("原始值：a = %d, b = %d\n\n", a, b);
    swap_1(a, b);
    printf("swap_1后：a = %d, b = %d\n\n", a, b);
    swap_2(&a, &b);
    printf("swap_2后：a = %d, b = %d\n\n", a, b);
    
    system("pause");
    return 0;
}