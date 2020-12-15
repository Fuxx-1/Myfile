#include <stdio.h>
#include <math.h>
#include <algorithm>
int main(void)
{
    int x, y, ans = 0;
    scanf("%d%d", &x, &y);
    if (!(x - y))
    {
        ans--;
    }
    y *= x;
    for (int i = 1; i <= sqrt(y); i++)
    {
        if (y % i == 0 && std::__gcd(i, y / i) == x)
        {
            ans += 2;
        }
    }
    printf("%d", ans);
    return 0;
}