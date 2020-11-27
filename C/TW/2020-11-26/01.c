#include <stdio.h>
int a[100][100];
int main(void)
{
    int n = 0, count = 1;
    scanf("%d", &n);
    a[0][0] = a[1][0] = a[1][1] =1;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < count; j++)
        {
            if (i != 0 && i != 1)
            {
                a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
            }
            printf("%d", a[i][j]);
            if (i - 1 != count)
            {
                printf(" ");
            }
        }
        printf("\n");
        count++;
    }
    return 0;
}
