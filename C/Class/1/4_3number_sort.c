/* 
����������������
���ɴ�С���
 */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int a, b, c, t;
    printf("��������������\n");
    scanf("%d%d%d", &a, &b, &c);
    printf("�����������:\n%d, %d, %d\n", a, b, c);
    if (a < b)
    {
        t = a;
        a = b;
        b = t;
    }
    if (b < c)
    {
        t = b;
        b = c;
        c = t;
    }
    printf("�����������:\n%d, %d, %d\n", a, b, c);

    system("pause");
    return 0;
}