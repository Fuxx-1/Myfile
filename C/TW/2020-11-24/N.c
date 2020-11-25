/* Yes */
#include <stdio.h>
#include <math.h>

int main(void)
{
    double n, m;

    while (scanf("%lf%lf", &n, &m) != EOF)
    {
        double out = 0;
        for (int i = 0; i < m; i++)
        {
            out += n;
            n = sqrt(n);
        }
        printf("%.2f\n", out);
    }

    return 0;
}