#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int n = 10 ;
    int i;
    int a[10];
    int s1 = 3;
    int s2 = 3;
    a[0] = s1;
    a[1] = s2;
    for (i = 2; i <= n; i++)
        a[i] = a[i - 2] + a[i - 1];
    scanf("%d", &i);
    printf("%d", a[i]);
}