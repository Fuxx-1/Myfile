#include <stdio.h>
char pend[100000005];
int odd[10000000];
int main(void)
{
    int n, m, count = 1, val;
    scanf("%d%d", &n, &m);
    pend[1] = 1;
    for (int i = 2; i * i <= 100000005; i++)
    {
        if (!pend[i])
        {
            for (int j = i * i; j <= 100000005; j += i)
            {
                pend[j] = 1;
            }
        }
    }
    for (int i = 1; i < 100000005; i++)
    {
        if (!pend[i])
        {
            odd[count++] = i;
        }
    }
    for (int i = 0; i < m; i++)
    {
        scanf("%d", &val);
        printf("%d\n", odd[val]);
    }
    return 0;
}