#include <stdio.h>
#include <math.h>
int main(void)
{
    float x1, x2, y1, y2;
    while (scanf("%f%f%f%f", &x1, &y1, &x2, &y2) != EOF)
    {
        float x3 = x2 - x1;
        float y3 = y2 - y1;
        printf("%.2f\n", sqrt((x3 * x3) + (y3 * y3)));
    }
    return 0;
}