#include <stdio.h>
int main(void)
{
    int n, t;
    scanf("%d%d", &t, &n);
    int a[100][2];
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d", &a[i][0], &a[i][1]);
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            double e1 = a[i][1] / (double)a[i][0], e2 = a[j][1] / (double)a[j][0];
            if (e1 < e2)
            {
                for (int k = 0; k < 2; k++)
                {
                    double temp;
                    temp = a[i][k];
                    a[i][k] = a[j][k];
                    a[j][k] = temp;
                }
            }
        }
    }
    double sum1, sum2;
    for (int i = 0; i < n; i++)
    {
        if (t - sum1 > a[i][0])
        {
            sum1 += a[i][0];
            sum2 += a[i][1];
        }
        else if (t - sum1 == a[i][0])
        {
            sum1 += a[i][0];
            sum2 += a[i][1];
            break;
        }
        else if (t - sum1 < a[i][0])
        {
            continue;
        }
    }
    printf("%.0f", sum2);
    return 0;
}