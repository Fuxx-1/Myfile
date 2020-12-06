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
    int n, m, wor, z = 0, o = 0;
    char ans[1000][100];
    char temp[100];
    while (scanf("%d%d", &n, &m) != EOF)
    {
        z++;
        char bin = getchar();
        char dic[50][100], sen[50][100];
        int a[50], b[50];
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
            count = count < b[i] ? b[i] : count;
        }
        strcpy(&ans[o][0], "Excuse Set #");
        o++;
        for (int i = 0; i < m; i++)
        {
            if (b[i] == count)
            {
                strcpy(&ans[o][0], &sen[i][0]);
                o++;
            }
        }
    }
    strcpy(&ans[o][0], "##");
    o = 0;
    for (int i = 0; i < z + 1; i++)
    {
        for (;;)
        {
            strcpy(temp, &ans[o][0]);
            if (temp[0] == 'E' && temp[1] == 'x')
            {
                printf("\n");
                printf("%s", temp);
                printf("%d", i + 1);
                o++;
                break;
            }
            else if (temp[0] == '#' && temp[1] == '#')
            {
                break;
            }
            puts(temp);
            o++;
        }
        printf("\n");
    }

    return 0;
}