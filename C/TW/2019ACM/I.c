#include <stdio.h>
#include <math.h>
int main(void)
{
    int t, n, count;
    scanf("%d", &t);
    for (int i = 0; i < t; i++)
    {
        count = 0;
        scanf("%d", &n);
        for (; (1 / sqrt(5) * (pow((1 + sqrt(5)) / 2, n) - pow((1 - sqrt(5)) / 2, n))) / pow(10, count) > 1;)
        {
            count++;
        }
        if (count == 0)
        {
            printf("1\n");
        }
        else
        {
            printf("%d\n", count);
        }
    }
    return 0;
}