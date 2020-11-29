#include <stdio.h>
#include <algorithm>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[1000][4], b;
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d", &a[i][0], &a[i][1]);
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j <= std::max(a[i][0], a[i][1]); j++)
        {
            b = (a[i][0] ^ j) & (a[i][1] ^ j);
            if (a[i][2] > b || j == 0)
            {
                a[i][3] = j;
                a[i][2] = b;
            }
        }
        if (!a[i][3])
        {
            printf("1");
        }
        else
        {
            printf("%d\n", a[i][3]);
        }
    }
    return 0;
}