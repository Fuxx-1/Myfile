/* 
任意输入两个整数x. y
交换变量x，y的值 不引入中间变量
 */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int a, b;
    printf("请输入要交换的两个数：\n");
    scanf("%d%d", &a, &b);
    printf("a:%d, b:%d\n", a, b);

    a += b;
    b = a-b;
    a -= b;

    printf("a:%d, b:%d\n", a, b);

    system("pause");
    return 0;
}