#include <stdio.h>
int main(void)
{
    char a[101];
    char b[101];
    int c = 0;
    gets(a);
    gets(b);
    for (int i = 0; i < 101; i++)
    {
        if (a[i] == '\0' && b[i] == '\0')
        {
            c = 0;
            break;
        }
        else if (a[i] == b[i])
        {
            c = 0;
        }
        else if (a[i] > b[i] || b[i] == '\0')
        {
            c = 1;
            break;
        }
        else if (a[i] < b[i] || a[i] == '\0')
        {
            c = -1;
            break;
        }
    }
    printf("%d", c);
    return 0;
}