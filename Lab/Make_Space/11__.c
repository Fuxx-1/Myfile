/*
11.	����Ǹ�������������ƽʱ����ѧϰ��ľ����ڲٳ������񣬷���������������
	����һ����һ�񣬿���һ�����������ʣ����������n���м���������������
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
	printf("����̨��");
	scanf("%d", &n);
	printf("%d", tiao(n));
	return 0;
}
