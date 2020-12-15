#include <stdio.h>
#include <math.h>
#include <algorithm>
int main(void)
{
    long long int x, y, flag1, flag2, temp1, temp2, count = 0;
    scanf("%lld%lld", &x, &y);
    for (int i = 1; i < y; i++)
    {
        for (int j = i + 1; j <= y; j++)
        {
            flag1 = flag2 = 0;
            if (i % 2 || j % 2)
            {
                temp1 = std::__gcd(i, j);
            }
            else
            {
                temp1 = 2 * std::__gcd(i / 2, j / 2);
            }

            if (temp1 == x)
            {
                flag1 = 1;
            }
            temp2 = i * j / temp1;
            if (temp2 == y)
            {
                flag2 = 1;
            }
            if (flag1 && flag2 && i != j)
            {
                count += 2;
            }
            else if (flag1 && flag2)
            {
                count++;
            }
        }
    }
    printf("%lld", count);
    return 0;
}