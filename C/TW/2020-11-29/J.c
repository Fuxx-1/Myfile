#include <stdio.h>
int a[1000];
int c[2000000];
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
        int b = a[i];
        for (int j = 0; j < b; j++)
        {
            c[j] = j + 1;
        }
        printf("2\n");
        for (int j = 0; j < b - 1; j++)
        {
            printf("%d %d\n", c[b - j - 2], c[b - j - 1]);
            c[b - j - 2] = (c[b - j - 2] + c[b - j - 1]) / 2 + (c[b - j - 2] + c[b - j - 1]) % 2;
        }
    }
    return 0;
}