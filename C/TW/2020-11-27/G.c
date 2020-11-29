#include <stdio.h>
int main(void)
{
    long long int n;
    scanf("%lld", &n);
    if (n == 0)
        printf("0");
    else
    {
        if (!((n + 1) % 2))
            printf("%lld", (n + 1) / 2);
        else
            printf("%lld", n + 1);
    }
    return 0;
}
