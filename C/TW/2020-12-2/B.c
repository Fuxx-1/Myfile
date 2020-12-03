#include <stdio.h>
#include <string.h>
int strl(char a[])
{
    int count = 0;
    for (int i = 0; 1; i++)
    {
        if (a[i] != ' ' && a[i] != 0)
            count++;
        else
            break;
    }
    return count;
}
int main(void)
{
    int n, b;
    int a[201];
    scanf("%d", &n);
    char str[201];
    for (int i = 0; i <= n; i++)
    {
        memset(str, 0, sizeof(str));
        gets(str);
        b = 0;
        b = strl(str);
        if (b <= 3)
        {
            a[i] = 1;
        }
        else
        {
            a[i] = 0;
        }
    }
    for (int i = 1; i <= n; i++)
    {
        if (a[i])
        {
            printf("Too easy!\n");
        }
        else
        {
            printf("Too hard!\n");
        }
    }
    return 0;
}