/* 
任意输入一个四位正整数
输出ac db的值
 */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int a;
    printf("请输入四位正整数：\n");
    scanf("%d", &a);
    printf("输入的值: %d\n", a);
    int t1, t2, t3, t4;
    t1 = a % 10;
    t2 = a / 10 % 10;
    t3 = a / 100 % 10;
    t4 = a / 1000;
    int b, c;
    b = t4 * 10 + t2;
    c = t3 * 10 + t1;
    printf("%d, %d\n", b, c);
    
    system("pause");
    return 0;
}