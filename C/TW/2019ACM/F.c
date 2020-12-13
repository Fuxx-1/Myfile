#include <stdio.h>
int main(void)
{
    int t, b[25];
    scanf("%d", &t);
    long long int n, c;
    for (int i = 0; i < t; i++)
    {
        int count = 0;
        scanf("%lld%lld", &n, &c);
        for (long long int j = 0; j < n; j++)
        {
            long long int k = n - j;
            if (k % c + j % c == c && k + j == n)
            {
                count++;
            }
        }
        b[i] = count;
    }
    for (int i = 0; i < t; i++)
    {
        if (b[i])
        {
            printf("%d\n", b[i]);
        }
        else
        {
            printf("-1\n");
        }
    }
    return 0;
}