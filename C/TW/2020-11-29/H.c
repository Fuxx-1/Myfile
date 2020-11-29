#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[1001];
    int b, c, d;
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < n; i++)
    {
        d = 0;
        for (int j = 0; j <= a[i] / 7; j++)
        {
            b = a[i] - j * 7;
            for (int k = 0; k <= b / 5; k++)
            {
                c = b - k * 5;
                if (!(c % 3))
                {
                    printf("%d %d %d\n", c / 3, k, j);
                    d = 1;
                    break;
                }
            }
            if (d)
            {
                break;
            }
        }
        if (d == 0)
        {
            printf("-1\n");
        }
    }
    return 0;
}