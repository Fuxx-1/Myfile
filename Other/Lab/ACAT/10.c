#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{
    char a[100];
    int n, num;
    printf("�������ַ�����\n");
    gets(a);
    printf("��������������\n");
    scanf("%d", &n);
    num = strlen(a);
    for (int i = 0; i < n; i++)
    {
        a[num + i] = a[i]; 
    }
    printf("�������ַ���\n");
    for (int i = n; i < n + num; i++)
    {
        printf("%c", a[i]);
    }
    printf("\n");
    
    system("pause");
    return 0;
}