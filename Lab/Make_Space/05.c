/*
5.请你将右侧四行代码放入结构体中使其 size 最小，并解释为什么这样最小。 
struct node
{
	char a;
	int b;
	short c;
	char d;
};
int main()
{
	printf("%d",sizeof(node));
} 
*/
#include <stdio.h>
#include <stdlib.h>
struct node
{
    char a;  //1
    char d;  //1
    short c; //2
    int b;   //4
};
int main()
{
    printf("%d", sizeof(node));

    printf("\n");
    system("pause");
    return 0;
}

/*
1： 整体空间是占用空间最大的成员（的类型）所占字节数的整数倍，若最大成员类型所占
    字节数超过4，如double是8，则整体空间是4的倍数即可。
2： 数据对齐原则。内存按结构体成员的先后顺序排列，当排到该成员变量时，其前面已摆
    放的空间大小必须是该成员类型大小的整数倍，如果不够则补齐，依次向后类推。
    某成员类型所占字节数超过4，如double是8，则前面已摆放的空间大小是4的整数倍即可，
    不够则补齐。
*/
