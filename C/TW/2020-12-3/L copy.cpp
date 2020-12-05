#include <stdio.h>
#include <algorithm>
#include <string.h>
int main(void)
{
    int n, count = 0, t;
    scanf("%d", &n);
    int a[10000], temp[3];
    int ans[10000][3];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    std::sort(a, a + n);
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            for (int k = j + 1; k < n; k++)
            {
                if (a[i] + a[j] + a[k] == 0)
                {
                    printf("%d %d %d\n", a[i], a[j], a[k]);
                    count++;
                }
            }
        }
    }
    if (!count)
    {
        printf("No Solution\n");
    }
    return 0;
}