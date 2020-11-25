#include <stdio.h>
#include <math.h>

int main(void)
{
    int n, m;
    while(scanf("%d%d", &n, &m) != EOF);
    {
        double out = 0;
        for (int i = 0; i < m; i++)
        {
            out += sqrt(n);
            n = sqrt(n);
        }
        printf("%.2f\n", out);
    }
    return 0;
}