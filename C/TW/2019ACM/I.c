#include <stdio.h>
#include <math.h>
int main(void)
{
    int t, n, count;
    int val;
    scanf("%d", &t);
    for (int i = 0; i < t; i++)
    {
        val = 0;
        scanf("%d", &n);
        for (; (1 / sqrt(5) * (pow((1 + sqrt(5)) / 2, n) - pow((1 - sqrt(5)) / 2, n))) / pow(10, val - 1) != 0;)
        {
            val++;
        }
        printf("%d\n", val);
    }
    return 0;
}