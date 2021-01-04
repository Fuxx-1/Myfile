#include <stdio.h>
int main(void)
{
    int n;
    while (scanf("%d", &n) != EOF)
    {
        int a = 0, b = 1, count = 0;
        for (int i = 0; i < n; i++)
        {
            scanf("%d", &a);
            if (a % 2)
            {
                b *= a;
                count++;
            }
            if (!(i - n + 1) && count)
            {
                printf("%d\n", b);
            }
        }
    }
    return 0;
}