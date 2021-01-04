/* 
6.写一个程序实现二进制到八进制的转换。
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void)
{

    char a[30];
    int b[30];
    int c[10];
    b[0] = '0';
    printf("请键入二进制数:\n");
    gets(a);
    int n = strlen(a);
    for (int i = 0; i < n; i++)
    {
        b[i] = a[i];
        b[i] -= '1' - 1;
    }
    /* Input */
    int *p, *q;
    int m = !(!(n % 3)) + (n / 3);
    p = &b[n - 1];
    q = &c[m - 1];
    for (int i = 0; i < m; i++)
    {
        *q = *p  + *(p - 1) * 2 + *(p - 2)* 4;
        p -= 3;
        q -= 1;
    }
    for (int i = 0; i < m; i++)
    {
        printf("%d", c[i]);
    }
    printf("\n");

    system("pause");
    return 0;
}