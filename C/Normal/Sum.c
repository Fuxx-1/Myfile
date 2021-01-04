#include <stdio.h>
int main()
{
    int n;
    while (scanf("%d", &n) != EOF)
    {
        int i, sum = 0;
        for (i = 0; i <= n; i++)
        {
            sum += i;
        }
        printf("%d\n", sum);
    }

    return 0;
}