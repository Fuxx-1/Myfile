#include <stdio.h>
#include <stdlib.h>
int com(int *a,int *t)
{
    for (int i = 0; i < t; i++)
    {
        if (a[i] > 3)
        {
            a[i] /= 3;
            reutrn 1;
        }
    }
    
}
int main(void)
{
    int n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        int t = 0;
        scanf("%d",&t);
        int a[t];
        for (int i = 0; i < t; i++)
        {
            scanf("%d", &a[i]);
        }
        
    }
    


    system("pause");
    return 0;
}