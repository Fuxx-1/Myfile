#include <stdio.h>
int main(void)
{
    int m, n;
    while (scanf("%d%d", &m, &n) != EOF)
    {
        unsigned long long a = 0, b = 0;
        for (int i = m; i <= n; i++)
        {
            if (i % 2)
            {
                b += (i * i * i);
            }
            else if (!(i % 2))
            {
                a += (i * i);
            }
        }
        printf("%d %d\n", a, b);
    }
    return 0;
}