#include <stdio.h>
#include <string.h>
char str1[11];
char str2[1000000];
int count1, count2, loc;
int main(void)
{
    gets(str1);
    gets(str2);
    int s1 = strlen(str1);
    int s2 = strlen(str2);
    for (int i = 0; i < s2; i++)
    {
        count1 = 0;
        for (int j = 0; j < s1; j++)
        {
            if (str2[i + j] == str1[j] || str2[i + j] == str1[j] + 'A' - 'a' || str2[i + j] == str1[j] + 'a' - 'A')
            {
                count1++;
            }
            if (str2[i + s1] != ' ')
            {
                count1--;
                break;
            }
        }
        if (count1 == s1)
        {
            if (count2 == 0)
            {
                loc = i;
            }
            count2++;
        }
    }
    if (count2 == 0)
    {
        printf("-1");
    }
    else
    {
        printf("%d %d", count2, loc);
    }
    return 0;
}
