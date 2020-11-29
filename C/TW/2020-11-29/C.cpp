#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    long long a[1000][2];
    for (int i = 0; i < n; i++)
    {
        scanf("%lld%lld", &a[i][0], &a[i][1]);
    }
    for (int i = 0; i < n; i++)
    {
        long long int c = a[i][0] & a[i][1];
        if (!c)
            printf("1\n");
        else
            printf("%lld\n", c);
    }
    return 0;
}