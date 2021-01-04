#include <stdio.h>
int main(void)
{
    int t, count, p;
    scanf("%d", &t);
    int n, m, temp;
    int a[25];
    for (int k = 0; k < t; k++)
    {
        p = 1;
        count = 0;
        scanf("%d%d", &n, &m);
        int b[2000];
        char bin = getchar();
        for (int i = 0; i < m * 2; i++)
        {
            scanf("%d", &b[i]);
        }
        b[2 * m] = 0;
        for (int l = 0; 1; l++)
        {
            if (p > n)
            {
                break;
            }
            for (int i = 0; i < 2 * m + 1; i++)
            {
                if (b[i] == p)
                {
                    p++;
                    break;
                }
                else if (i == 2 * m)
                {
                    p++;
                    count++;
                }
            }
        }
        for (int i = 0; i < m * 2; i += 2)
        {
            for (int j = 0; j < m * 2; j += 2)
            {
                if (b[i] < b[j])
                {
                    temp = b[i];
                    b[i] = b[j];
                    b[j] = temp;
                    temp = b[i + 1];
                    b[i + 1] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < m * 2; i++)
        {
            if (b[i] == b[i + 1])
            {
                for (int j = i; j < 2 * m; j++)
                {
                    b[j] = b[j + 2];
                }
            }
        }
        int q = 0;
        for (int i = 0;; i++)
        {
            if (b[i] != 0)
            {
                q++;
            }
            else
            {
                break;
            }
        }
        a[k] = q / 2 + count;
    }

    for (int i = 0; i < t; i++)
    {
        printf("%d\n", a[i]);
    }

    return 0;
}