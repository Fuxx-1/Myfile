#include <stdio.h>
#include <algorithm>
int a[1000][1000];
int b[1000];
int sum;
int main(void)
{
    int n, m, t, o, temp;
    scanf("%d", &n);
    for (int k = 0; k < n; k++)
    {
        scanf("%d", &m);
        o = 1;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < o; j++)
            {
                scanf("%d", &a[i][j]);
            }
            o++;
        }
        t = m;
        for (int j = 0; j < m; j++)
        {
            for (int i = 0; i < t; i++)
            {
                temp = std::max(a[m - j][i], a[m - j][i + 1]);
                a[m - j - 1][i] += temp;
            }
            t--;
        }
        b[k] = a[0][0];
    }
    for (int i = 0; i < n; i++)
    {
        printf("%d\n", b[i]);
    }

    return 0;
}