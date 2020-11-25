#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int a[n];
    int b[n];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < n; i++)
    {
        b[i] = 0;
        for (int j = 0; j = 1 ; j++)
        {
            if(a[i] % 2 == 1)
                b[i] += 1;
            else if(a[i] == 0)
                break;
            a[i] = a[i] / 2;
        }
        printf("%d\n", b[i]);
    }
    
    system("pause");
    return 0;
}