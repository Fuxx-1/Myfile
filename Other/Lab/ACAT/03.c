/* 
3����int a=0,b=5;ִ�б��ʽ++a||++b,a+b��a,b�ͱ��ʽ��ֵ�ֱ��ǣ���

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