#include <stdio.h>
int strl(char a[])
{
    int count = 0;
    for (int i = 0; 1; i++)
    {
        if (a[i] != 0)
            count++;
        else
            break;
    }
    return count;
}
int main(void)
{
    char str1[101];
    char str2[101];
    int count1 = 0, count2 = 0;
    scanf("%s", &str1[0]);
    scanf("%s", &str2[0]);
    count1 = strl(str1);
    count2 = strl(str2);
    for (int i = 0; i < count2 + 1; i++)
    {
        str1[count1 + i] = str2[i];
    }
    printf("%s", str1);
    return 0;
}