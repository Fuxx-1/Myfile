#include <stdio.h>
int main(void)
{
    int n, m;
    while (scanf("%d%d", &n, &m) != EOF)
    {
        int sum = 0, a = 2, count = 0;
        for (int i = 0; i < ((n / m) * m); i++)
        {
            sum += a;
            if (((i + 1) % m == 0) && i)
            {
                printf("%d", sum / m);
                sum = 0;
                count++;
                if (count != 0)
                    printf(" ");
            }
            a += 2;
        }
        sum = 0;
        for (int i = 0; i < n % m; i++)
        {
            sum += a;
            if ((i + 1) % (n % m) == 0)
            {
                printf("%d", sum / (n % m));
            }
            a += 2;
        }
        printf("\n");
    }
    return 0;
}