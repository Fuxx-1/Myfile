/*
下面代码输出什么？ 
#define f(x) x*x*x
	int x = 1, y = 3;
	int a =f(x-y);
printf("%d",a);
*/

#define f(x) x *x *x //定义函数

#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int x = 1, y = 3;
    int a = f(x - y);
    printf("%d", a);
    /*
    以上为题目
    */

    printf("\n");

    system("pause");
    return 0;
}