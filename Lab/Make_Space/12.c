/*
12.旭旭假期在澳门赌场做荷官，现在他手里有10张扑克牌，分别是J Q K 1 2 3 4 5 6 7，
	请帮旭旭想想应该怎么洗牌，才能保证牌被随机打乱。
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
