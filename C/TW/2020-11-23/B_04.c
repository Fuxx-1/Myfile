#include <stdio.h>
// 打表部分
// int sg[10009];
// bool vis[10000];
/* int sg(int a)
{
    if (a % 8 == 0)
    {
        return a - 1;
    }
    if ((a + 1) % 8 == 0)
    {
        return a + 1;
    }
    return a;
}
int main()
{
    int T;
    scanf("%d", &T);
    while (T--)
    {
        int n;
        scanf("%d", &n);
        int ans = 0;
        while (n--)
        {
            int t;
            scanf("%d", &t);
            ans ^= sg(t);
            if (!ans)
            {
                printf("Second player wins.\n");
            }
            else
                printf("First player wins.\n");
        }
    }
} */