#include <stdio.h>
#include <algorithm>
int main(void)
{
    int n;
    scanf("%d", &n);
    static int a[200];
    int count = 0;
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
                if (a[i] + a[j] == a[k])
                {
                    count++;
                }
            }
        }
    }
    printf("%d",count);
    return 0;
}