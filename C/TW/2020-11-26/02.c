#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    int count;
    for (int i = 0; i < n; i++)
    {
        count = 0;
        for (int j = 0; j < i; j++)
        {
            if (a[j] < a[i])
            {
                count++;
            }
        }
        printf("%d", count);
        if (i - 1 != n)
        {
            printf(" ");
        }
    }
    printf("\n");
    return 0;
}