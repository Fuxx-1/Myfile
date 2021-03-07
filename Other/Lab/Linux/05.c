/* 
下面程序会出现什么结果？为什么会出现这样的结果？
&a = 0061FF10   &a[0] = 0061FF10        &a[0][0] = 0061FF10
&a+1 = 0061FF20 &a[0]+1 = 0061FF18      a[0][0]+1 = 0061FF14
&a			a[0][0]
&a[0]		a[0][0]
&a[0][0]	a[0][0]
&a+1		a[2][0]
&a[0]+1		a[1][0]
&a[0][0]+1	a[0][1]
 */
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	int a[2][2];
	printf("&a = %p\t&a[0] = %p\t&a[0][0] = %p\n", &a, &a[0], &a[0][0]);
	printf("&a+1 = %p\t&a[0]+1 = %p\ta[0][0]+1 = %p\n", &a+1, &a[0]+1, &a[0][0]+1);

	system("pause");
	return 0;
}
