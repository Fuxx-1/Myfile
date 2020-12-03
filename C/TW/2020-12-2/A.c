#include <stdio.h>
int str_len(char a[])
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
    char str[10000];
    gets(str);
    printf("%d\n", str_len(str));
    return 0;
}