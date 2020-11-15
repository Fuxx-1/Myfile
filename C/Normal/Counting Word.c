#include <stdio.h>
#include <stdlib.h>
int main()
{
    char a[81];

    printf("please input a sentence:\n");

    gets(a);

    int i, number = 1;

    if (a[0] == '\0')
        number = 0;

    for (i = 0; a[i] != '\0'; i++)
        if (a[i] != ' ' && a[i + 1] == ' ')
            number++;

    printf("This sentence has %d words in total.\n", number);
    
    printf("The sentence:\n%s\n", a);

    system("pause");
    return 0;
}
