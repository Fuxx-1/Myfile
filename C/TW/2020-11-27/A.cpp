#include <stdio.h>
#include <algorithm>
long long a[3];
int main(void)
{
    for (int i = 0; i < 3; i++)
    {
        scanf("%d", &a[i]);
    }
    int b[4];
    b[0] = a[0] + a[1] + a[2];
    b[1] = 2 * (a[0] + a[1]);
    b[2] = 2 * (a[0] + a[2]);
    b[3] = 2 * (a[1] + a[2]);
    std::sort(a, a + 3);
    std::sort(b, b + 4);
    if (a[0] < 1 || a[2] > 100000000)
    {
        1;
    }
    else
    {
        printf("%d", b[0]);
    }
    return 0;
}