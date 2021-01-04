#include <stdio.h>
#include <algorithm>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[n];
    int b[2000], c[2000];
    int count1 = 0, count2 = 0;
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    std::sort(a, a + n);
    for (int i = n - 1; i > -1; i--)
    {
        if (a[i] % 2)
        {
            b[count1] = a[i];
            count1++;
        }
        else if (!(a[i] % 2))
        {
            c[count2] = a[i];
            count2++;
        }
    }
    int m = 0;
    if (count1 > count2)
    {
        for (int i = 0; i < count1 - count2 - 1; i++)
        {
            m += b[count1 - 1 - i];
        }
    }
    else
    {
        for (int i = 0; i < count2 - count1 - 1; i++)
        {
            m += c[count2 - 1 - i];
        }
    }
    printf("%d", m);
    return 0;
}