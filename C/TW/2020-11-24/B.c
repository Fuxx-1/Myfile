/* 
������������ݼ����A + B��ֵ��
������һϵ�гɶԵ��ɿո�ָ������a��b���ɣ�һ������ռ��һ�С�
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