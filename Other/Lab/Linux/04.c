/* 
下面程序会出现什么结果？为什么会出现这样的结果？
ch = A i = A f = A
 */
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	char ch = 'A';				   //ch = 'A'
	int i = 65;					   //i = 65
	unsigned int f = 33554433;	   //10000000000000000000000001(2)
	*(int *)&f >>= 24;			   //10 000 000 000 000 000 000 000 001(2) => 10(2) => 2
	*(int *)&f = *(int *)&f + '?'; //'?' = 63
	printf("%d, %d\n", '?', 'A');
	printf("ch = %c i = %c f = %c\n", ch, i, *(int *)&f);

	system("pause");
	return 0;
}
