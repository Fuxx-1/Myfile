#include <stdio.h>
#include <string.h>
int main(void)
{
    int t;
    scanf("%d", &t);
    char str[10000];
    char str1[t][10000];
    char bin = getchar();
    for (int i = 0; i < t; i++)
    {
        gets(str);
        int n = strlen(str);
        for (int j = 0; j < n; j++)
        {
            if (str[j] == str[j - 1] && j - 1)
            {
                for (int k = j; k < n; k++)
                {
                    str[k] = str[k + 1];
                }
            }
        }
        strcpy(&str1[i][0], str);
    }
    for (int i = 0; i < t; i++)
    {
        strcpy(str, &str1[i][0]);
        puts(str);
    }
    return 0;
}