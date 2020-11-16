/* 请试着解释其输出 */
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
	unsigned char a = 255; //a = 255
	char ch = 128;		   //ch = -128
	a -= ch;			   //a = a - ch = 255 + 128 = 127(溢出)
	printf("a = %d ch = %d\n", a, ch);

	system("pause");
	return 0;
}
