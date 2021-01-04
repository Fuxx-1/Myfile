#include <stdio.h>
#include <windows.h>
int main()
{
	long a = 1;
	long b;
	a, b = 1;
	int c;
	int e;

	do
	{

		printf("compute n!, please input 'n'\n");

		scanf("%d", &c);

		printf("\n");

		for (int i = 1; i <= c; ++i)
		{
			b = a * (i);
			a = b;
			printf("%d\n", a);
		}

		printf("\n");
		printf("%d\n", a);
		printf("Do you want to continue?(1/0)\n");

		scanf("%d", &e);

	} while (e == 1);

	Sleep(2000);

	return 0;
}