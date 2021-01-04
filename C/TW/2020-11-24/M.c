#include <stdio.h>
int main(void)
{
    int n;
    double a;
    while (scanf("%d", &n) != EOF)
    {
        int count1 = 0, count2 = 0, count3 = 0;
        if (n)
        {
            for (int i = 0; i < n; i++)
            {
                scanf("%lf", &a);
                if (a < 0)
                    count1++;
                else if (a == 0)
                    count2++;
                else if (a > 0)
                    count3++;
            }
            printf("%d %d %d\n", count1, count2, count3);
        }
    }

    return 0;
}