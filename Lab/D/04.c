#include <stdio.h>
#include <stdlib.h>

int strlen_1(char* n)
{
    int count = 0;
    char *p = n;
    for(; (char)*p != '\0'; *p++)
    {
        count++;
    }
    return count;
}

int main(void)
{
    char a[10] = "lak";
    printf("%d\n", strlen_1(a));

    system("pause");
    return 0;
}