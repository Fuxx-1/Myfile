#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    char str[1001];
    long long  a[1001][200], sum;
    for (int i = 0; i < n; i++)
    {
        char bin = getchar();
        char val = getchar();
        if (val == 'a' || val == 'b' || val == 'c')
        {
            str[i] = val;
        }
        else
        {
            str[i] = str[i - 1];
            ungetc(val, stdin);
        }
        scanf("%lld%lld", &a[i][0], &a[i][1]);
    }
    for (int i = 0; i < n; i++)
    {
        sum = 0;
        if (str[i] == 'a')
        {
            sum = printf("%lld+%lld=%lld\n", a[i][0], a[i][1], a[i][0] + a[i][1]);
        }
        else if (str[i] == 'b')
        {
            sum = printf("%lld-%lld=%lld\n", a[i][0], a[i][1], a[i][0] - a[i][1]);
        }
        else if (str[i] == 'c')
        {
            sum = printf("%lld*%lld=%lld\n", a[i][0], a[i][1], a[i][0] * a[i][1]);
        }
        if (i + 1 != n)
        {
            printf("%lld\n", sum - 1);
        }
        else if (i + 1 == n)
        {
            printf("%lld\n", sum - 1);
        }
    }
    return 0;
}
