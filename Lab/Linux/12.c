/* 请随机输入一串字符串，你能解释一下输出结果吗？ */
#include <stdio.h>

int main(int argc, char *argv[])
{
	char str[1121];
	int key;
	char t;

	fgets(str, 1121, stdin);

	for(int i = 0; i < strlen(str) - 1; i++)
	{
		key = i;

		for(int j = i + 1; j < strlen(str) - 1; j++)
		{
			if(str[key] > str[j])
			{
				key = j;
			}
		}

		t = str[key];
		str[key] = str[i];
		str[i] = t;
	}

	puts(str);
	return 0;
}
