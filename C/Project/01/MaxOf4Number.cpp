#include <algorithm>
#include <stdio.h>
int main(void)
{
    int a[4];
    for (int i = 0; i < 4; i++)
    {
        scanf("%d", &a[i]);
    }
    std::sort(a, a + 4);
    printf("%d", a[3]);
    return 0;
}