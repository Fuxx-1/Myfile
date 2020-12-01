#include <stdio.h>
#include <string.h>
int strl(char a[])
{
    int count = 0;
    for (int i = 0; 1; i++)
    {
        if (a[i] != 0 && a[i] != ' ')
            count++;
        else
            break;
    }
    return count;
}
int main(void)
{
    char a[1000];
    int ans = 0;
    while (scanf("%s", &a) != EOF)
    {
        ans += strl(a);
    }
    printf("%d", ans);

    return 0;
}
