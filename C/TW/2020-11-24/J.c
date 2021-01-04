#include <stdio.h>
#define PI 3.1415927
int main(void)
{
    double n;
    while (scanf("%lf", &n) != EOF)
    {
        double v = (n * n * n * (4.00) * PI)/3;
        printf("%.3f\n", v);
    }
    return 0;
}