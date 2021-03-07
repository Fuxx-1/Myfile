#include <stdio.h>
int main(void)
{
	double a, b;
	int x;

	scanf("%lf%lf", &a, &b);

	x = (int)(((a - b) / b * 100) + 0.5);
	if (x < 10)
	{
		printf("OK\n");
	}
	else if (x >= 10 && x < 50)
	{
		printf("Exceed %d%%. Ticket 200", x);
	}
	else
	{
		printf("Exceed %d%%. License Revoked", x);
	}

	return 0;
}