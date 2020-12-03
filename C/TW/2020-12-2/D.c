#include <stdio.h>
#include <string.h>
int com(char *p, char *q)
{
    for (;;)
    {
        if (*p != 0 && *p != *q)
            return 0;
        if (*p == 0)
            return 1;
        p++;
        q++;
    }
}
int main(void)
{
    int n, m, wor;
    scanf("%d%d", &n, &m);
    char bin = getchar();
    char dic[20][100], sen[20][100];
    int a[20], b[20];
    char temp[100];
    char *p, *q;
    for (int i = 0; i < n; i++)
    {
        p = &dic[i][0];
        gets(p);
    }
    for (int i = 0; i < m; i++)
    {
        gets(temp);
        strcpy(&sen[i][0], temp);
        a[i] = strlen(temp);
    }
    /* 输入部分 */
    int count;
    for (int i = 0; i < m; i++)
    {
        count = 0;
        for (int j = 0; j < n; j++)
        {
            for (int k = 0; k < a[i]; k++)
            {
                p = &dic[j][0];
                q = &sen[i][k];
                if (com(p, q))
                {
                    count++;
                }
            }
        }
        b[i] = count;
    }
    count = 0;
    for (int i = 0; i < m; i++)
    {
        count = count < b[i] ? b[i]:count; 
    }
    for (int i = 0; i < m; i++)
    {
        if (b[i] == count)
        {
            strcpy(temp, &sen[i][0]);
            puts(temp);
        }
    }
    printf("\n");
    return 0;
}