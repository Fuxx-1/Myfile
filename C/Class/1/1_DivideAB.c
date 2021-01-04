/* 
任意输入一个实数x
分别输出整数和小数部分
 */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    double a = 0;
    scanf("%lf", &a);
    
    int b = (int)a;
    double c = a - b;

    printf("%d\n", b);
    printf("%lf\n", c);

    system("pause");
    return 0;    
}