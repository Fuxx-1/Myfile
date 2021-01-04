#include <stdio.h>
#include <string.h>
int main(void)
{
    int a[3] = {0, 0, 0};
    char str[256];
    gets(str);
    for (int i = 0; i < strlen(str); i++)
    {
        if ((str[i] == 'a' || str[i] == 'b' || str[i] == 'c') && str[i + 1] == ':' && str[i + 2] == '=' && str[i + 3] >= '0' && str[i + 3] <= '9')
        {
            a[str[i] - 'a'] = str[i + 3] - '0';
        }
        if ((str[i] == 'a' || str[i] == 'b' || str[i] == 'c') && str[i + 1] == ':' && str[i + 2] == '=' && str[i + 3] >= 'a' && str[i + 3] <= 'c')
        {
            a[str[i] - 'a'] = a[str[i + 3] - 'a'];
        }
    }
    printf("%d %d %d", a[0], a[1], a[2]);
    return 0;
}
