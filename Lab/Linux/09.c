/* ���¶γ����У����ǿ���ͨ����һ����ӡ��a�ĵ�ַ��
��������Ļ��������ӡ�����0x7ffd737c6db4������
�ڵڶ�����scanf�����������ֵַ�������c�У���������
�������-�����֣��������������ʲô�������֪�����е�ԭ���� */
#include <stdio.h>
#include <stdlib.h>

void func()
{
	int a = 2020;
	int c;
	printf("%p\n", &a);
	printf("�҂���Ҫ�޸ĵĵ�ַ��");
	scanf("%lx", &c);
	printf("Ո�S��ݔ��һ�����֣�");
	scanf("%d", (int *)c);
	printf("a = %d\n", a);
}
int main(void)
{
	func();
	
	system("pause");
	return 0;
}