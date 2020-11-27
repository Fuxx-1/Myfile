#include <stdio.h>
int main(void)
{
    int n, k;
    scanf("%d%d", &n, &k);
    int a[101];
    int j;
    for (int i = 0; i < 100; i += k)
    {
        for (j = 0; j < k; j++)
        {
            if (i + j > 100)
            {
                break;
            }
            a[i + j] = 'a' + j;
        }
    }
    for (int i = 0; i < n; i++)
    {
        printf("%c", a[i]);
    }
    printf("\n");
    return 0;
}
