#include <stdio.h>
int main(void)
{
    double a, b, c, d;
    scanf("%lf%lf%lf%lf", &a, &b, &c, &d);
    double i = -100.00;
    while (i <= 100)
    {
        double Y = (a * i * i * i + b * i * i + c * i + d) * (a * (i+ 0.001) * (i+ 0.001) * (i+ 0.001) + b * (i+ 0.001) * (i+ 0.001) + c * (i+ 0.001) + d);
        if (Y <= 0)
        {
            printf("%.2f ", i);
        }
        i += 0.001;
    }
    return 0;
}