#include <stdio.h>
#include <string.h>
int main(void)
{
    char str[50][101];
    int n = 0;
    int a[50];
    for (int i = 0;; i++)
    {
        char val;
        scanf("%c", &val);
        if (val == EOF)
        {
            break;
        }
        else if (val == '/n')
        {
            n++;
            break;
        }
        else
        {
            ungetc(val, stdin);
        }
        scanf("%c", &str[n][i]);
    }
    for (int i = 0; i <= n; i++)
    {
        a[i] = strlen(&str[i]);
    }
    for (int j = 0; j <= n; j++)
    {
        for (int i = 0; i <= a[j]; i++)
        {
            if (str[j][i] >= 'a' && (str[j][i - 1] == ' ' || !i))
            {
                str[j][i] = str[i] - 'a' + 'A';
            }
        }
    }
    for (int i = 0; i <= n; i++)
    {
        printf("%s", str);
    }
    return 0;
}