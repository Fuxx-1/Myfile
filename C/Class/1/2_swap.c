/* 
����������������x. y
��������x��y��ֵ �������м����
 */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int a, b;
    printf("������Ҫ��������������\n");
    scanf("%d%d", &a, &b);
    printf("a:%d, b:%d\n", a, b);

    a += b;
    b = a-b;
    a -= b;

    printf("a:%d, b:%d\n", a, b);

    system("pause");
    return 0;
}