#include <stdio.h>
int main(void)
{
    int n, m = 0;
    scanf("%d", &n);
    for (int i = 1; i < n; i++)
    {
        m = 0;
        for (int j = 1; j < n; j++)
        {
            if (i % j == 0)
            {
                m += j;
            }
        }
        if (m == n)
        {
            printf("%d\n", i);
            break;
        }
        if (i + 1 == n)
        {
            printf("-1\n");
        }
    }
    return 0;
}