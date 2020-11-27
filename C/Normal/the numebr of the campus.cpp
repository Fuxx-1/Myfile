#include <stdio.h>
#include <algorithm>
int main(void)
{
    int a[10000];
    int i = 0, n = 0;
    while (scanf("%d", a[i]) != EOF)
    {
        i++;
        n++;
    }
    std::sort(a, a + n);
    for (int i = 0; i < n - 1; i++)
    {
        if (a[i] == a[i + 1])
        {
            printf("%d", a[i]);
            break;
        }
    }
    return 0;
}