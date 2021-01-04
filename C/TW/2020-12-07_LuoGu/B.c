#include <stdio.h>
int main(void)
{
    int n;
    char str[65010];
    for (int i = 0;; i++)
    {
        scanf("%c", &str[i]);
        if (str[i] == 'E')
        {
            n = i;
            break;
        }
    }
    int a[2] = {0, 0};
    for (int i = 0; i <= n; i++)
    {
        if (str[i] == 'W')
        {
            a[0]++;
        }
        else if (str[i] == 'L')
        {
            a[1]++;
        }
        if (((a[0] >= 11 || a[1] >= 11) && (a[0] - a[1] >= 2 || a[1] - a[0] >= 2)) || i == n)
        {
            printf("%d:%d\n", a[0], a[1]);
            a[0] = a[1] = 0;
        }
    }
    printf("\n");
    for (int i = 0; i <= n; i++)
    {
        if (str[i] == 'W')
        {
            a[0]++;
        }
        else if (str[i] == 'L')
        {
            a[1]++;
        }
        if (((a[0] >= 21 || a[1] >= 21) && (a[0] - a[1] >= 2 || a[1] - a[0] >= 2)) || i == n)
        {
            printf("%d:%d\n", a[0], a[1]);
            a[0] = a[1] = 0;
        }
    }
    return 0;
}