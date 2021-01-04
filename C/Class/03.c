#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int a;
    scanf("%d", &a);
    if (a % 2 == 0)
        a = a + 1;
    printf("%d", a);

    system("pause");
    return 0;
}