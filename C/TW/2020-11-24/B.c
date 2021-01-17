/* 
根据输入的内容计算出A + B的值。
输入由一系列成对的由空格分割的整数a和b构成，一对输入占用一行。
 */
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a, b;
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d", &a, &b);
        printf("%d\n", a + b);
    }
    return 0;
}