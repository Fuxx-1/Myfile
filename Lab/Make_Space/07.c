/*
7���������¶������䣺
char c1='b',c2='e'; 
printf("%d,%c\n",c2-c1,c2-'a'+'A'); 
����������:����
A. 2,M B. 3,E C. 2,E    D. ��������Ӧ�ĸ�ʽ���Ʋ�һ��,��������ȷ����
*/
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    char c1 = 'b', c2 = 'e';
    printf("%d,%c\n",c1-c2,c2-'a'+'A');
    
    system("pause");
    return 0;
}