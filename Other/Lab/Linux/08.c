/* 
如下程序，根据打印结果，你有什么思考？
XiyouLinuxGroup2021
Waiting for y0u!
 */
#include <stdio.h>
#include <stdlib.h>

int add(int *x, int y)
{
	return *x = (*x ^ y) + ((*x & y) << 1); //&是按位与
}

int a;

int main(int argc, char *argv[])
{
	int b = 2020;

	if (add(&b, 1) || add(&a, 1))
	{
		printf("XiyouLinuxGroup%d\n", b);
		printf("Waiting for y%du!\n", a);
	}

	if (add(&b, 1) && a++)
	{
		printf("XiyouLinuxGroup%d", b);
		printf("Waiting for y%du!\n", a);
	}

	system("pause");
	return 0;
}
