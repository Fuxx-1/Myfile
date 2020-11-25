#include <stdio.h>
int main(void)
{
    int n, m;
    scanf("%d%d", &n, &m);
    int a[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    int b = 0, min;
    for (int i = 0; i < n - m; i++)
    {
        b = 0;
        for (int j = 0; j < m; j++)
        {
            b += a[i + j];
        }
        if (b <= min || i == 0)
            min = b;
    }
    if (!m || !n)
    {
        min = 0;
    }
    else if(!(m - n))
    {
        for (int j = 0; j < m; j++)
        {
            b += a[j];
        }
        min = b;
    }
    printf("%d", min);
    return 0;
}