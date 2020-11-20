/* 下面程序会出现什么结果？为什么会出现这样的结果？ */
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int a[2][2];
	printf("&a = %p\t&a[0] = %p\t&a[0][0] = %p\n", &a, &a[0], &a[0][0]);
	printf("&a+a = %p\t&a[0]+1 = %p\ta[0][0]+1 = %p\n", &a+1, &a[0]+1, &a[0][0]+1);

	system("pause");
	return 0;
}
