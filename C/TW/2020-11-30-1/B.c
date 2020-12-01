#include <stdio.h>
int main(void)
{
    char a[101];
    gets(a);
    for (int i = 0; i < 101; i++)
    {
        if (a[i] > 92 && a[i] != '\0')
        {
            a[i] = a[i] + ('A' - 'a');
        }
    }
    puts(a);
    return 0;
}