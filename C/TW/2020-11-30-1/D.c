#include <stdio.h>
int main(void)
{
    char a[101];
    int count = 0;
    gets(a);
    for (int i = 0; i < 101; i++)
    {
        if (a[i] != '\0')
        {
            count++;
        }
        else
        {
            break;
        }
        
    }
    printf("%d", count);
    return 0;
}