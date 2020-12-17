#include <stdio.h>
int main(void)
{
    long long int n, ans = 0;
    scanf("%lld", &n);
    for (int i = n; i > 4; i--)
    {
        ans += i / 5 + i / 25 + i / 125 + i / 625 + i / 3125 + i / 15625 + i / 78125 + i / 390625 + i / 1953125 + i / 9765625 + i / 48828125;
        // while (temp)
        // {
        //     ans += temp / 5;
        //     temp /= 5;
        // }
    }
    printf("%lld", ans);
    return 0;
}

/* 打表 */

// #include <stdio.h>
// #include <math.h>
// int main(void)
// {
//     long long int n = 5;
//     while (n < 2147483648)
//     {
//         printf(" + i / %lld", n);
//         n *= 5;
//     }
//     return 0;
// }