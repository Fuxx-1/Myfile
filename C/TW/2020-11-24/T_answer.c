#include <stdio.h>
int main(void)
{
    int n, m;
    while (scanf("%d%d", &n, &m) != EOF)
    {
        int sum = 0, ai = 2, count = 0, i;
        for (i = 1; i <= n; i++)
        {
            sum += ai;
            ai += 2;
            if (i % m == 0)
            {
                count++;
                if (count != 1)
                    printf(" ");
                printf("%d", sum / m);
                sum = 0;
            }
        }
        if (n % m == 0)
            printf("\n");
        else
            printf(" %d\n", sum / (n % m));
    }
    return 0;
}