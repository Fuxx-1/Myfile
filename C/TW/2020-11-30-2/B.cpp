#include <stdio.h>
#include <string.h>
#include <algorithm>
int a[26];
int main(void)
{
    char str[200];
    int n;
    scanf("%s", &str);
    for (int i = 0; i < strlen(str); i++)
    {
        a[str[i] - 'a']++;
    }
    std::sort(a, a + 26);
    for (int i = 0; i < 26; i++)
    {
        if (a[i] == a[25])
        {
            n = 0;
            break;
        }
        else if (a[i])
        {
            n = a[25] - a[i];
            break;
        }
    }
    for (int i = 2; i < n + 1; i++)
    {
        if (!(n % i))
        {
            if (!(i - n))
            {
                printf("Lucky Word\n%d", n);
                break;
            }
        }
    }
    if (!n || n == 1)
    {
        printf("No Answer\n0");
    }
    return 0;
}
