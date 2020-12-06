#include <stdio.h>
#include <string.h>
#include <algorithm>
long long int b[26];
int main(void)
{
    char a[10000];
    scanf("%s", &a);
    for (int i = 0; i < 10000; i++)
    {
        if (a[i] >= 65 && a[i] < 97 && a[i] != '\0')
        {
            a[i] = a[i] - ('A' - 'a');
        }
    }
    for (int i = 0; i < strlen(a); i++)
    {
        b[a[i] - 'a']++;
    }
    std::sort(b, b + 26);
    long long int n = 0;
    for (int i = 26; i > 0; i--)
    {
        n += (i * b[i - 1]);
    }
    printf("%lld\n", n);
    return 0;
}