/* 
7.������һ���������������ĺ������������ַ�������ʵ����������ԣ�����������������������ԣ�˵˵ԭ����������еķ����ɣ�
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
    printf("ԭʼֵ��a = %d, b = %d\n\n", a, b);
    swap_1(a, b);
    printf("swap_1��a = %d, b = %d\n\n", a, b);
    swap_2(&a, &b);
    printf("swap_2��a = %d, b = %d\n\n", a, b);
    
    system("pause");
    return 0;
}