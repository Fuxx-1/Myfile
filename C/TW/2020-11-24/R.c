#include <stdio.h>
int count(int n)
{
    if (n == 1)
        return 1;
    else if (n >= 1)
        return (2 * (count(n - 1) + 1));
}
int main(void)
{
    int n;
    while (scanf("%d", &n) !=EOF)
    {
        printf("%d\n", count(n));
    }
    return 0;
}