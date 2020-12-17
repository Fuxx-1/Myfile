#include <stdio.h>
int main(void)
{
    unsigned long long int x, y, sum = 0;
    scanf("%lld%lld", &x, &y);
    for (int i = x; i <= y; i++)
    {
        for (int j = 1; j <= i; j++)
        {
            if (!(i % j))
            {
                sum += j;
            }
        }
    }
    printf("%lld", sum);
    return 0;
}