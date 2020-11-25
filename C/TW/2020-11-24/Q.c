#include <stdio.h>
int main(void)
{
    int x[1000], y[1000];
    int n;
    for (int i = 0; ; i++)
    {
        scanf("%d%d", &x[i], &y[i]);
        if (!x[i] && !y[i])
        {
            n = i;
            break;
        }
    }
    for (int k = 0; k < n; k++)
    {
        for (int i = x[k]; i <= y[k]; i++)
        {
            int count = 0;
            int val = i * i + i + 41;
            for (int j = 2; j < val; j++)
            {
                if (!(val % j))
                {
                    printf("Sorry\n");
                    count++;
                    break;
                }
            }
            if (count == 0 && i == y[k])
            {
                printf("OK\n");
            }
            else if (count == 1)
            {
                break;
            }
            
        }
    }
    return 0;
}