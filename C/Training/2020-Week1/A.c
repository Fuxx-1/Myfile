#include <stdio.h>
#include <string.h>
int cmp(char a[], char *q)
{
    int temp = strlen(a) - 5;
    for (int i = 0; i < temp; i++)
    {
        if (a[i + 5] == *q)
            q++;
        else
            return 0;
    }
    return temp;
}
int main(void)
{
    char a[50];
    char b[1000][50];
    int i = 0, temp, ans, flag;
    // gets(a);
    while (gets(a))
    {
        if (a[0] == 'i')
        {
            strcpy(&b[i][0], &a[7]);
            i++;
        }
        if (a[0] == 'f')
        {
            flag = 1;
            temp = i;
            while (--temp)
            {
                char *q = &b[temp][0];
                if (ans = cmp(a, q))
                {
                    printf("%s\n", &b[temp][ans + 1]);
                    flag = 0;
                }
            }
            if (flag)
            {
                printf("-1\n");
            }
        }
        if (a[0] == 'e')
        {
            break;
        }
    }
    return 0;
}