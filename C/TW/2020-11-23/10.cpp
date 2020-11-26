#include <stdio.h>
#include <algorithm>
int main(void)
{
    int a[3] = {3, 3, 3};
    std::sort(a, a+3);
    for (int i = 0; i < 3; i++)
    {
        printf("%d ", a[i]);
    }
    
    return 0;
}