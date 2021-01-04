/*
11.	彬彬是个秀气的男生，平时除了学习最爱的就是在操场跳方格，方格有两种跳法，
	可以一次跳一格，可以一次跳两格，请问，彬彬跳到第n格有几种美丽的跳法？
*/#include <stdio.h>
int sort(int n)
{
	if (n <= 3)
		return n;
	else
		return sort(n - 1) + sort(n - 2);
}
int main()
{
	int n;
	printf("输入台阶");
	scanf("%d", &n);
	printf("%d", tiao(n));
	return 0;
}
