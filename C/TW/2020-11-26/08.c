#include <stdio.h>
int main(void)
{
    double n;
    scanf("%lf", &n);
    int m = n * 10;
    int a1,a2,a3,a4;
    a1 = m % 10;
    a2 = (int)n % 10;
    a3 = (int)n / 10 % 10;
    a4 = (int)n / 100 % 10;
    float q = a1 + a2 / 10.0 + a3 / 100.0 + a4 / 1000.0;
    printf("%.3f", q);
    return 0;
}