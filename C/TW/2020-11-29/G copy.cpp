#include <stdio.h>
#include <algorithm>
int a[1000][1000];
int b[1000];
int sum;
int main(void)
{
    int n, m, o;
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
        for (int i = 0; i < m; i++)
        {
            int *p;
            p = &a[m][i];
            sum = 0;
            for (int l = 0; l < m; l++)
            {
                if (*(p - 1000) > *(p - 1001))
                {
                    sum += *p;
                    p = p - 1000;
                }
                else
                {
                    sum += *p;
                    p = p - 1001;
                }
            }
            sum += *p;
            if (sum > b[k] || i == 0)
            {
                b[k] = sum;
            }
        }
    }
    for (int i = 0; i < n; i++)
    {
        printf("%d\n", b[i]);
    }

    return 0;
}