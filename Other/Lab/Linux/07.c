/* 
下面代码的运行输出结果是什么，并说说你的理解。
16 4 25 24
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[])
{
	char str[] = "XiyouLinuxGroup";
	char *p = str;
	char x[] = "XiyouLinuxGroup\t\106F\bamily";
	printf(str);
	printf("%zu %zu %zu %zu\n", sizeof(str), psizeof(), sizeof(x), strlen(x));
	
	system("pause");
	return 0;
}
