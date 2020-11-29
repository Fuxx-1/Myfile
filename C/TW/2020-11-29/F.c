#include <stdio.h>
int n, b;
int main(void)
{
    scanf("%d", &n);
    int a[1000][2];
    for (int i = 0; i < n; i++)
    {
        scanf("%d%d", &a[i][0], &a[i][1]);
    }
    for (int i = 0; i < n; i++)
    {
        if (a[i][0] % (a[i][1] + 1) == 0)
        {
            printf("second\n");
        }
        else
        {
            printf("first\n");
        }
    }
    return 0;
}