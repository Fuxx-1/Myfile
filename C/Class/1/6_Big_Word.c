/* 
����ɴ�д��Сд
�����д
 */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    char a;
    printf("��������ĸ��\n");
    scanf("%c", &a);
    printf("�������ĸ��\n%c\n", a);
    if (a > 65)
    {
        a = a + ('A' - 'a');
    }
    printf("�������ĸ��\n%c\n", a);

    system("pause");
    return 0;
}