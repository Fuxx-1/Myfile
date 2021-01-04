#include <stdio.h>
int main(void)
{
    int m, n;
    scanf("%d%d", &m, &n);
    int a = m * 10 + n;
    printf("%d", a / 19);
    return 0;
}