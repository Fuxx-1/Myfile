#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    char s[] = "AAA";
    // char *s = "AAA";
    printf("%s\n", s);
    s[0] = 'B';
    printf("%s\n", s);

    system("pause");
    return 0;
}
