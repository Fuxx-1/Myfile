/* ���г���Ĺ�����ʲô����ʲô���⣬�����ҳ����Ⲣ������� */
#include <stdio.h>
#include <stdlib.h>

int* get_array()
{
	static int array[1121];
	for(int i = 0; i < sizeof(array) / sizeof(int); i++)
	{
		array[i] = i;
	}
	return array;
}

int main(int argc, char *argv[])
{
	int *p = get_array();

	for (int i = 0; i < 1121; i++)
	{
		printf("%d\n", *p);
		p += 1;
	}
	
	system("pause");
	return 0;
}
