#include <stdio.h>
int main(int argc, char const *argv[])
{
    int i, j;
    scanf("%1d", &i);
    printf("%d\n", i);
    ungetc(i, stdin);
    scanf("%d", &j);
    printf("%d", j);
    return 0;
}
