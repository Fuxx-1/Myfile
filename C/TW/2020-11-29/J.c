#include <stdio.h>
int a[10000];
int b[1000];
int main(void)
{
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < n; i++)
    {
        printf("2\n");
        printf("%d", n - 1)
    }
    
    return 0;
}