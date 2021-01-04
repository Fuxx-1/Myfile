#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int a[3][3] = {{2}, {4}, {6}};
    for (int i = 0; i <= 2; i++)
    {
        printf("%d\n", a[0][i]);
        printf("%d\n", a[1][i]);
        printf("%d\n", a[2][i]);
    }
    system("pause");
    return 0;
}