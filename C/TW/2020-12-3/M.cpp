#include <stdio.h>
#include <string.h>
int main(void)
{
    int n, count = 0, j, k, l;
    scanf("%d", &n);
    int a[1000];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            for (int k = j + 1; k < n; k++)
            {
                for (int l = 0; l < n; l++)
                {
                    if ((a[i] + a[j] + a[k] + a[l] == 0) && l - k && l - j && l - i)
                    {
                        count = 1;
                    }
                }
            }
        }
    }
    if (count)
    {
        printf("Yes\n");
    }
    else
    {
        printf("No\n");
    }

    return 0;
}