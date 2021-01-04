/* 
任意输入正整数
若是奇数 输出
若是偶数 输出比x大于一的奇数
 */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int a;
    printf("请输入正整数：\n");
    scanf("%d", &a);
    printf("输入的正整数：\n%d\n", a);
    if (!(a % 2))
    {
        a = a + 1;
    }
    printf("输出：\n%d\n", a);

    system("pause");
    return 0;
}