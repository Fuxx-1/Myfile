#include <stdio.h>
int sum(int x, int y);
int main(void)
{
	int a, b, c;
	scanf("%d %d", &a, &b);
	c = sum(a, b);
	printf("%d\n", c);
	return 0;
}
int sum(int x, int y)
{
	return (x + y);
}

