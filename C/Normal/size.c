#include <stdio.h>
#include <stdlib.h>
int main(void)
{
	printf("%d\n", sizeof(char));
	printf("%d\n", sizeof(short));
	printf("%d\n", sizeof(int));
	printf("%d\n", sizeof(long));
	printf("%d\n", sizeof(long long));
	printf("%d\n", sizeof(float));
	printf("%d\n", sizeof(double));

	system("pause");
	return 0;
}
/*
1 2 4 4 8 4 8
*/