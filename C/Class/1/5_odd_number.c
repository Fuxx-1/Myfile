/* 
��������������
�������� ���
����ż�� �����x����һ������
 */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int a;
    printf("��������������\n");
    scanf("%d", &a);
    printf("�������������\n%d\n", a);
    if (!(a % 2))
    {
        a = a + 1;
    }
    printf("�����\n%d\n", a);

    system("pause");
    return 0;
}