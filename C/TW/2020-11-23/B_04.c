#include <stdio.h>
/*打表部分
int sg[10009];
bool vis[10000];
void init()
{
    memset(sg, 0, sizeof(sg));
    for (int = 1;
         i <= 201;
         i++)
    {
        memset(vis, 0, sizeof(vis));
        for (int j = 0; j < i; j++)
        {
            vis[sg[j]] = 1;
        }
        for (int j = 1; j < i; j++)
        {
            for (int k = 1;
                 k < i;
                 k++)
            {
                int y = i - j - k;
                if (y > 0)
                    vis[sg[j] ^ sg[k] ^ sg[y]] = 1;
            }
        }
        for (int j = 0;; j++)
        {
            if (!vis[j])
            {
                sg[i] = j;
                break;
            }
        }
    }
*/

int sg(int a)
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
}