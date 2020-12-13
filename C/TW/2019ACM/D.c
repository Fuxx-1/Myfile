#include <stdio.h>
int main(void)
{
    int t, flag;
    scanf("%d", &t);
    int n, k, val, a[4], b[100010];
    for (int i = 0; i < t; i++)
    {
        scanf("%d%d", &n, &k);
        for (int l = 0; l < n; l++)
        {
            scanf("%d", &b[l]);
        }
        for (int l = 0; l < n; l++)
        {
            a[0] = a[1] = a[2] = a[3] = 0;
            b[l] ^= k;
            for (int j = 3; j >= 0; j--)
            {
                flag = 1;
                for (int k = 0; k < 8; k++)
                {
                    a[j] += b[l] % 2 * flag;
                    flag *= 2;
                    b[l] /= 2;
                }
            }
            printf("%c%c%c%c", a[3], a[2], a[1], a[0]);
        }
    }
    printf("\n");
    return 0;
}