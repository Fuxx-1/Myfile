#include <stdio.h>
#include <string.h>
int main(void)
{
    int a[10] = {(0, 1), 2, 3, 4};
    int* p;
    p = a[0];
    printf("%d", p[0]);
    
    return 0;
}