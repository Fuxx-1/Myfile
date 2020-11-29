#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[1000][2];
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d", &a[i][0], &a[i][1]);
    }
    int b1, b2;
    for (int i = 0; i < n; i++)
    {
        b1 = b2 = 0;
        for (int j = 1; j < a[i][0]; j++)
        {
            if (!(a[i][0] % j))
            {
                b1 += j;
            }
        }
        for (int j = 1; j < a[i][1]; j++)
        {
            if (!(a[i][1] % j))
            {
                b2 += j;
            }
        }
        if (b1 == a[i][1] && b2 == a[i][0])
        {
            printf("YES\n");
        }
        else
        {
            printf("NO\n");
        }
    }
    return 0;
}