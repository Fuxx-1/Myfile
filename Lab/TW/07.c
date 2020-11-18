#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    char a[] = "ABCDEFGHIJKLMO";
    char b[] = "HAHAHAHAHAHAHAHAHAHAGAGA";
    char c[] = "WANGDAIQING";
    char d[] = "GRANDFATHERD";
    char e[] = "THOUGHTWORKS YIGEIWOLIGIAOGIAO ILOVETW HELLOWORLD";
    for (int i = 0; i < 14; i++)
    {
        printf("%X ", a[i]);
    }
    printf("\n");
    for (int i = 0; i < 24; i++)
    {
        printf("%X ", b[i]);
    }
    printf("\n");
    for (int i = 0; i < 11; i++)
    {
        printf("%X ", c[i]);
    }
    printf("\n");
    for (int i = 0; i < 12; i++)
    {
        printf("%X ", d[i]);
    }
    printf("\n");
    for (int i = 0; i < 52; i++)
    {
        if (a[i] != ' ')
            printf("%X ", e[i]);
        else
            printf("\n");

    }
    system("pause");
    return 0;
}