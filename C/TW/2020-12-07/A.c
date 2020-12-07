#include <stdio.h>
int main(void)
{
    int n, t;
    scanf("%d%d", &n, &t);
    double a[n][3];
    for (int i = 0; i < n; i++)
    {
        scanf("%lf%lf", &a[i][0], &a[i][1]);
    }
    for (int i = 0; i < n; i++)
    {
        a[i][2] = (double)a[i][1] / a[i][0];
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (a[i][2] < a[j][2])
            {
                for (int k = 0; k < 3; k++)
                {
                    double temp;
                    temp = (double)a[i][k];
                    a[i][k] = (double)a[j][k];
                    a[j][k] = (double)temp;
                }
            }
        }
    }
    double sum1, sum2;
    for (int i = 0; 1; i++)
    {
        sum1 += a[i][0];
        sum2 += a[i][1];
        n = i;
        if (sum1 - t >= 0 || i + 1 == t)
        {
            break;
        }
    }
    if (sum1 == t)
    {
        printf("%.2f", sum2);
    }
    else
    {
        int q = sum1 - t;
        sum2 -= a[n][2] * (double)q;
        printf("%.2f", sum2);
    }
    
    
    return 0;
}