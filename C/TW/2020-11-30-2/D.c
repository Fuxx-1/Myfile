#include <stdio.h>
#include <string.h>
int main(void)
{
    int val1 = 1, val2 = 1;
    char b[7];
    gets(b);
    int b1 = strlen(b);
    char c[7];
    gets(c);
    int c1 = strlen(c);
    int a[26];
    for (int i = 0; i < 26; i++)
    {
        a[i] = i + 1;
    }
    for (int i = 0; i < b1; i++)
    {
        val1 *= a[b[i] - 'A'];
    }
    for (int i = 0; i < c1; i++)
    {
        val2 *= a[c[i] - 'A'];
    }
    if (val1 % 47 == val2 % 47)
    {
        printf("GO");
    }
    else
    {
        printf("STAY");
    }
    return 0;
}
