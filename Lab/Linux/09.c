/* 在下段程序中，我们可以通过第一步打印出a的地址，
假如在你的机器上面打印结果是0x7ffd737c6db4；我们
在第二步用scanf函数将这个地址值输入变量c中；第三步，
随机输入-个数字，请问最终输出了什么结果，你知道其中的原理吗？ */
#include <stdio.h>
#include <stdlib.h>

void func()
{
	int a = 2020;
	int c;
	printf("%p\n", &a);
	printf("我們想要修改的地址：");
	scanf("%lx", &c);
	printf("請隨便輸入一個數字：");
	scanf("%d", (int *)c);
	printf("a = %d\n", a);
}
int main(void)
{
	func();
	
	system("pause");
	return 0;
}