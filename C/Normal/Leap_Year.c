#include <stdio.h>
#include <stdlib.h>
int main()
{
    int t, t1, n;
    scanf("%d", &t);
    t1 = t;
    while(t--)
    {
        scanf("%d", &n);
        if ((n%4==0 && n%100!=0) || (n%400==0))
            printf("Yes\n");
        else
            printf("No\n");
    }
    system("pause");
    return 0;
}