#include <stdio.h>
#include <string.h>
int main(void)
{
    char str[51];
    char str1[51];
    int m, count, val = 1;
    scanf("%s", &str);
    strcpy(str1, str);
    strrev(str);
    m = strlen(str);
    for (int i = m; i < 51; i++)
    {
        str[i] = str1[i];
    }
    for (int i = 0; i < m; i++)
    {
        if (str[i] == str1[i])
            count++;
        else
            break;
    }
    for (int i = 0; i < m; i++)
    {
        if (str[i] != str[0])
        {
            val = 0;
            break;
        }
    }
    if (count == m)
    {
        if (val)
        {
            count = 0;
        }
        else
        {
            count--;
        }
        printf("%d\n", count);
    }
    else
    {
        printf("%d\n", m);
    }
    return 0;
}
