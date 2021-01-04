/* 
任意输入三个整数
按由大到小输出
 */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int a, b, c, t;
    printf("请输入三个数：\n");
    scanf("%d%d%d", &a, &b, &c);
    printf("输入的三个数:\n%d, %d, %d\n", a, b, c);
    if (a < b)
    {
        t = a;
        a = b;
        b = t;
    }
    if (b < c)
    {
        t = b;
        b = c;
        c = t;
    }
    printf("排序后三个数:\n%d, %d, %d\n", a, b, c);

    system("pause");
    return 0;
}