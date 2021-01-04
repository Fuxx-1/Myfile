#include <stdio.h>
#include <algorithm>
int main(void)
{
    int n, count = 2;
    scanf("%d", &n);
    int a[100000];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    std::sort(a, a + n);
    for (int i = 0; i < n - 1; i++)
    {
        if (a[i] == a[i + 1])
            count++;
        else
            break;
    }
    if (a[0] != a[n - 1])
    {
        for (int i = n - 1; i > 1; i--)
        {
            if (a[i] == a[i - 1])
                count++;
            else
                break;
        }
    }
    else
    {
        count--;
    }
    printf("%d\n", n - count);
    return 0;
}