#include <stdio.h>
int pend(int a)
{
    for (int i = 2; i * i <= a; i++)
    {
        if (!(a % i))
        {
            if (i != a)
            {
                return 0;
            }
        }
    }
    return 1;
}
int main(void)
{
    int a[501];
    int count = 0, b, c, ans;
    for (int i = 0; 1; i++)
    {
        scanf("%d", &a[i]);
        if (a[i] == 0)
        {
            break;
        }
        count++;
    }
    for (int i = 0; i < count; i++)
    {
        b = 3, ans = 0;
        for (int j = 3; j < a[i] / 2; j++)
        {
            if (pend(j) && pend(a[i] - j) && b != c)
            {
                ans++;
            }
        }
        printf("%d\n", ans);
    }
    return 0;
}