#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    if ((5 * n) < (11 + 3 * n)) 
    {
        printf("Local");
    }
    else
    {
        printf("Luogu");
    }
    return 0;
}