#include <stdio.h>
int main(void)
{
    int a[4];
    for (int i = 0; i < 4; i++)
    {
        scanf("%d", &a[i]);
    }
    int min = (a[2] - a[0]) * 60 + a[3] - a[1];
    a[0] = min / 60;
    a[1] = min % 60;
    printf("%d ", a[0]);
    printf("%d", a[1]);
    return 0;
}