#include <stdio.h>
int a[10000];
int b[1000];
int main(void)
{
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < n; i++)
    {
        for (int i = 0; i < 1000; i++)
        {
            b[i] = i + 1;
        }
        int c = a[i] - 1;
        for (int l = 0; l < a[i] - 1; l++)
        {
            for (int j = 0; j < c + 1; j++)
            {
                for (int k = j + 1; k < c + 1; k++)
                {
                    if ((b[j] + b[k]) % 2  == 0 && (b[j] + b[k]) % 2 % 2  == 1)
                    {
                        printf("%d %d\n", b[j], b[k]);
                        b[j] = (b[j] + b[k]) / 2;
                        b[k] = b[c];
                        c--;
                    }
                    else if (j == c - 1 && k == c)
                    {
                        printf("%d %d\n", b[j], b[k]);
                        b[j] = (b[j] + b[k]) / 2 + 1;
                        b[k] = b[c];
                        c--;
                    }
                }
            }
        }
        printf("%d", b[0]);
    }

    return 0;
}