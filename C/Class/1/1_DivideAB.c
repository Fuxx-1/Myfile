/* 
��������һ��ʵ��x
�ֱ����������С������
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