#include <stdio.h>
#include <string.h>
int main(void)
{
    int k;
    char a[1000];
    char b[1000];
    int count, flag = 0;
    while (scanf("%d", &k) != EOF)
    {
        ungetc(k, stdin);
        gets(a);
        gets(b);
        count = flag =  0;
        for (int i = 0; i < strlen(a); i++)
        {
            for (int j = flag; j < strlen(b); j++)
            {
                if (a[i] == b[j])
                {
                    count++;
                    flag = j;
                    break;
                }
            }
        }
        printf("%d\n", count);
    }
    return 0;
}