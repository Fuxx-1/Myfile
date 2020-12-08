#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int flag1 = 0, flag2 = 0;
    char bin = getchar();
    char a[n];
    gets(a);
    for (int i = 0; i < n; i++)
    {
        if (a[i] == '1')
            flag1++;
        else if (a[i] == '0')
            flag2++;
    }
    n = n - (flag1 > flag2 ? flag2 : flag1) * 2;
    printf("%d\n", n);
    return 0;
}