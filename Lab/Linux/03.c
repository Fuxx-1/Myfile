/* 下面程序会出现什么结果？为什么会出现这样的结果？ */
#include <stdio.h>
#include <stdlib.h>
int i = 2;
void func()
{
	static int j = 1;
	printf("================%d===============\n",j++);
	if(i != 0)
	{
		static int m = 0;
		int n = 0;
		n++;
		m++;
		printf("m = %d, n = %d\n", m, n);
		i--;
		func();
	}
	else
	{
		return;
	}
}

int main(int argc, char *argv[])
{
	func();

	system("pause");
	return 0;
}
