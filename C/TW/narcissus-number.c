#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    while (scanf("%d%d", &m, &n) != EOF)
    {
        int m, n;
        int a1, a2, a3;
        int time = 0;
        for (int i = m; i <= n; i++)
        {
            a1 = i % 10;
            a2 = i / 10 % 10;
            a3 = i / 100;
            if (!(i - a1 * a1 * a1 - a2 * a2 * a2 - a3 * a3 * a3))
            {
                printf("%d ", i);
                continue;
                time++;
            }
            else if (time == 0 && i == n)
            {
                printf("no\n");
            }
        }
    }
    system("Pause");
    return 0;
}