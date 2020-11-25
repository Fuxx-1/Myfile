#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[1000];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < n; i++)
    {
        double out = 0.0;
        for (int j = 1; j <= a[i]; j++)
        {
            if (j % 2)
            {
                out += (1.0 / j);
            }
            else if (!(j % 2))
            {
                out -= (1.0 / j);
            }
        }
        printf("%.2f\n", out);
    }
    return 0;
}