/*
12.��������ڰ��Ŷĳ����ɹ٣�������������10���˿��ƣ��ֱ���J Q K 1 2 3 4 5 6 7��
	�����������Ӧ����ôϴ�ƣ����ܱ�֤�Ʊ�������ҡ�
*/#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
int main()
{
	char a[10] = {'J', 'Q', 'K', '1', '2', '3', '4', '5', '6', '7'};
	int n = 10;
	int i, j, T = 10, tmp;
	srand((time(NULL)));
	while (T--)
	{
		i = rand() % n;
		j = rand() % n;
		tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	for (i = 0; i < n; i++)
		printf("%c\n", a[i]);
	puts("");
	system("pause");
	return 0;
}
