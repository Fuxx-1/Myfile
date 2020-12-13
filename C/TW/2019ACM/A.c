#include <stdio.h>
#include <math.h>
int main(void)
{
    int t;
    scanf("%d", &t);
    int a, b, c, d;
    for (int i = 0; i < t; i++)
    {
        scanf("%d%d%d%d", &a, &b, &c, &d);
        printf("%.2f\n", sqrt((a - c) * (a - c) + (-b - d) * (-b - d)));
    }
    return 0;
}