#include <stdio.h>
#include <algorithm>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    std::sort(a, a + n);
    printf("%d", a[n - 1] - a[0]);
    return 0;
}