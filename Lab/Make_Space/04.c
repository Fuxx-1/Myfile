/*
����������ʲô�� 
#define f(x) x*x*x
	int x = 1, y = 3;
	int a =f(x-y);
printf("%d",a);
*/

#define f(x) x *x *x //���庯��

#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int x = 1, y = 3;
    int a = f(x - y);
    printf("%d", a);
    /*
    ����Ϊ��Ŀ
    */

    printf("\n");

    system("pause");
    return 0;
}