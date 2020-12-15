#include <stdio.h>
int main(void)
{
    int t, n, val, ans;
    scanf("%d", &t);
    for (int i = 0; i < t; i++)
    {
        ans = 0;
        scanf("%d", &n);
        for (int j = 0; j < n; j++)
        {
            scanf("%d", &val);
            ans ^= val;
        }
        if (!ans)
        {
            printf("No\n");
        }
        else
        {
            printf("Yes\n");
        }
    }
    return 0;
}