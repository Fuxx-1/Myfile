#include <stdio.h>
int main(void)
{
    char a[201];
    gets(a);
    for (int i = 0; i < 201; i++)
    {
        if (a[i] >= 65 && a[i] < 97 && a[i] != '\0')
        {
            a[i] = a[i] - ('A' - 'a');
        }
    }
    puts(a);
    return 0;
}