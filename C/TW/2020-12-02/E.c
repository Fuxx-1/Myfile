#include <stdio.h>
#include <string.h>
int strl(char *p)
{
    int count = 0;
    for (int i = 0; 1; i++)
    {
        if (*p != '\n')
        {
            count++;
        }
        else
        {
            break;
        }
        p++;
    }
    return count;
}
int compare(int *p, int *q)
{
    for (int i = 0; i < 26; i++)
    {
        if (*p != *q)
        {
            return 0;
        }
        p++;
        q++;
    }
    return 1;
}

int dic_1[200][26];
int wor_1[200][26];
/* 全局变量 */

int main(void)
{
    char str[200][7];
    int dic = 0, i = 0, wor = 0;
    scanf("%c", &str[dic][i]);
    i++;
    while (str[dic][0] != 'X')
    {
        scanf("%c", &str[dic][i]);
        if (str[dic][i] == '\n')
        {
            dic++;
            i = 0;
        }
        else
            i++;
    }
    char bin[10];
    scanf("%s", &bin);
    scanf("%c", &bin);
    char word[200][7];
    i = 0;
    scanf("%c", &word[wor][i]);
    i++;
    while (word[wor][0] != 'X')
    {
        scanf("%c", &word[wor][i]);
        if (word[wor][i] == '\n')
        {
            wor++;
            i = 0;
        }
        else
            i++;
    }
    scanf("%s", &bin);
    scanf("%c", &bin);
    /* 录入部分 */
    char t;
    for (int i = 0; i < dic; i++)
    {
        for (int j = 0; j < dic; j++)
        {
            if (str[i][0] < str[j][0])
            {
                for (int k = 0; k < 7; k++)
                {
                    t = str[i][k];
                    str[i][k] = str[j][k];
                    str[j][k] = t;
                }
            }
        }
    }
    /* 1 */
    for (int i = 0; i < dic; i++)
    {
        for (int j = 0; j < dic; j++)
        {
            if (str[i][0] == str[j][0] && str[i][1] < str[j][1])
            {
                for (int k = 0; k < 7; k++)
                {
                    t = str[i][k];
                    str[i][k] = str[j][k];
                    str[j][k] = t;
                }
            }
        }
    }
    /* 2 */
    for (int i = 0; i < dic; i++)
    {
        for (int j = 0; j < dic; j++)
        {
            if (str[i][0] == str[j][0] && str[i][1] == str[j][1] && str[i][2] < str[j][2])
            {
                for (int k = 0; k < 7; k++)
                {
                    t = str[i][k];
                    str[i][k] = str[j][k];
                    str[j][k] = t;
                }
            }
        }
    }
    /* 3 */ 
    for (int i = 0; i < dic; i++)
    {
        for (int j = 0; j < dic; j++)
        {
            if (str[i][0] == str[j][0] && str[i][1] == str[j][1] && str[i][2] == str[j][2] && str[i][3] < str[j][3])
            {
                for (int k = 0; k < 7; k++)
                {
                    t = str[i][k];
                    str[i][k] = str[j][k];
                    str[j][k] = t;
                }
            }
        }
    }
    /* 4 */ 
    for (int i = 0; i < dic; i++)
    {
        for (int j = 0; j < dic; j++)
        {
            if (str[i][0] == str[j][0] && str[i][1] == str[j][1] && str[i][2] == str[j][2] && str[i][3] == str[j][3] && str[i][4] < str[j][4])
            {
                for (int k = 0; k < 7; k++)
                {
                    t = str[i][k];
                    str[i][k] = str[j][k];
                    str[j][k] = t;
                }
            }
        }
    }
    /* 5 */
    /* 排序部分 */

    for (int i = 0; i < dic; i++)
    {
        int d = strl(&str[i][0]);
        for (int j = 0; j < d; j++)
        {
            dic_1[i][str[i][j] - 'a']++;
        }
    }
    for (int i = 0; i < wor; i++)
    {
        int d = strl(&word[i][0]);
        for (int j = 0; j < d; j++)
        {
            wor_1[i][word[i][j] - 'a']++;
        }
    }
    /* 字典及“混乱”单词处理部分 */

    int count;
    for (int i = 0; i < wor; i++)
    {
        count = 0;
        for (int j = 0; j < dic; j++)
        {
            if (compare(&dic_1[j][0], &wor_1[i][0]))
            {
                for (int k = 0; k < strl(&str[j][0]); k++)
                {
                    printf("%c", str[j][k]);
                    count++;
                }
                printf("\n");
            }
            else if (j + 1 == dic && count == 0)
            {
                printf("NOT A VALID WORD\n");
            }
        }
        printf("******\n");
    }
    /* 比较及输出部分 */

    return 0;
}