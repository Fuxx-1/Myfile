#include <stdio.h>
#include <algorithm>
int a[1200][1200];
int b;
int sum;
int main(void)
{
    int m, t, o, temp;
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
    b = a[0][0];
    printf("%d\n", b);
    return 0;
}