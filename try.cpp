#include <stdio.h>
#include <stdlib.h>
#define N 500

void Xc(int *a, int n)
{
    int flag, k, plus;
    flag = N - 1;
    a[N] = 1;
    for (int i = 1; i < n + 1; i++)
    {
        plus = 0;
        for (int j = N - 1; j < flag; j--)
        {
            k = a[j] * i + plus;
            a[j] = k % 10;
            plus = k / 10;
        }
        while (plus)
        {
            a[flag] = plus % 10;
            flag--;
            plus = plus / 10;
        }
    }
    for (int i = N - 1; i > flag; i--)
    {
        printf("%d", a[i]);
    }
}

int main(void)
{

    int a[N], n;
    printf("请输入n的阶乘：\n");
    scanf("%d", &n);

    Xc(a, n);

    return 0;
}