#include <stdio.h>
char odd[100000005];
int main(void)
{
    int n, count = 0;
    scanf("%d", &n);
    odd[1] = 1;
    for (int i = 2; i * i <= n; i++)
    {
        if (!odd[i])
        {
            for (int j = i * i; j <= n; j += i)
            {
                odd[j] = 1;
            }
        }
    }
    for (int i = 1; i <= n; i++)
    {
        if (!odd[i])
        {
            count++;
        }
    }
    printf("%d", count);
    return 0;
}