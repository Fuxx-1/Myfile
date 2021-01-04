#include <stdio.h>
#include <algorithm>
int main(void)
{
    int a[10] = {0, 0, 1, 1, 3, 6, 6, 7, 9};
    int *n;
    n = std::lower_bound(a, a + 9, 1);
    int m = n - &a[0] + 1;
    printf("%d\n", m);
    int b = std::count(a, a + 9, 6);
    printf("%d\n", b);
    return 0;
}