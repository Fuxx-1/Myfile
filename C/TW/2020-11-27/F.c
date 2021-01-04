#include <stdio.h>
int main()
{
    int n, i, j;
    int sum;
    while (scanf("%d", &n) != EOF)
    {
        i = n / 2;
        j = n - i;
        sum = i * (i - 1) / 2 + j * (j - 1) / 2;
        printf("%d\n", sum);
    }
    return 0;
}
