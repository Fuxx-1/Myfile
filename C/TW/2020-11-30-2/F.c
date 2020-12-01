#include <stdio.h>
#include <string.h>
int strl(char a[])
{
    int count = 0;
    for (int i = 0; 1; i++)
    {
        if (a[i] != '.' && a[i] != '/' && a[i] != '%' && a[i] != 0)
            count++;
        else
            break;
    }
    return count;
}
int main(void)
{
    char str[21];
    gets(str);
    int n = strlen(str);
    int m1 = strl(str);
    int m2 = n - m1 - 1;
    char t;
    for (int i = 0; i < m1 / 2; i++)
    {
        t = str[i];
        str[i] = str[m1 - i - 1];
        str[m1 - i - 1] = t;
    }
    if (m2)
    {
        for (int i = 0; i < m2 / 2; i++)
        {
            t = str[m1 + m2 - i];
            str[m1 + m2 - i] = str[m1 + 1 + i];
            str[m1 + 1 + i] = t;
        }
    }
    while (str[strlen(str) - 1] == '0')
    {
        str[strlen(str) - 1] = 0;
    }
    while (str[0] == '0')
    {
        for (int i = 0; i < n; i++)
        {
            str[i] = str[i + 1];
        }
    }
    if (str[0] == '/' || str[0] == '%' || str[0] == 0)
    {
        printf("0\n");
    }
    else if (str[0] == '.')
    {
        printf("0.0\n");
    }
    else
    {
        puts(str);
    }
    return 0;
}