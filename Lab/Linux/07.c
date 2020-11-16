/* 下面代码的运行输出结果是什么，并说说你的理解。 */
#include <stdio.h>

int main(int argc, char *argv[])
{
	char str[] = "XiyouLinuxGroup";
	char *p = str;
	char x[] = "XiyouLinuxGroup\t\106F\bamily";
	printf("%zu %zu %zu %zu\n", sizeof(str), sizeof(p), sizeof(x), strlen(x));
	return 0;
}
