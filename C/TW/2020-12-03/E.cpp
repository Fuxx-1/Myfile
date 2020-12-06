#include <stdio.h>
#include <algorithm>
int main(void)
{
    int n, m, j = 0;
    scanf("%d%d", &n, &m);
    int a[n];
    int b[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = n - 1; i >= 0; i--)
    {
        if (a[i] >= m)
        {
            b[j] = a[i];
            j++;
        }
    }
    std::sort(b, b + j);
    for (int i = j - 1; i >= 0; i--)
    {
        printf("%d ", b[i]);
    }
    printf("\b\n");
    return 0;
}