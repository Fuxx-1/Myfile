#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int length, space, word, i;

    printf("How many floor do you want?\n");

    scanf("%d", &length);

    printf("-----------------------------------------------------------------------------------------------------------------\n");

    i = length;

    for (length; length >= 1; --length)
    {
        space = length - 1;
        word = (2 * i) - (2 * length) + 1;

        for (; space >= 1; space--)
            printf(" ");
        for (; word >= 1; --word)
            printf("*");

        printf("\n");
    }
    system("pause");
    return 0;
}