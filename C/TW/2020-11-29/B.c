#include <stdio.h>
int pend(int a)
{
    for (int i = a - 2; 1; i -= 2)
    {
        if (!(a % i))
        {
            if (i != 1)
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
    }
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
        for (int j = 0; 1; j++)
        {
            c = a[i] - b;
            if (pend(c) && pend(b) && b != c)
            {
                ans++;
            }
            b += 2;
            if (a[i] / 2 < b)
            {
                break;
            }
        }
        printf("%d\n", ans);
    }
    return 0;
}