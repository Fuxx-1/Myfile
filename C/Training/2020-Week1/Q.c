#include <stdio.h>
int main(void)
{
    char a[20];
    int count = 0;
    gets(a);
    for (int i = 0; i < 8; i++)
    {
        if (a[i] - '0')
        {
            count++;
        }
    }
    printf("%d", count);
    return 0;
}