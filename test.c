#include <stdio.h>
#include <math.h>
int main(void)
{
    int x1, x2, y1, y2;
    scanf("%d%d%d%d", &x1, &y1, &x2, &y2);
    int x3 = x2 - x1;
    int y3 = y2 - y1;
    printf("%.2f\n", sqrt((x3 * x3) + (y3 *y3)));
    return 0;
}