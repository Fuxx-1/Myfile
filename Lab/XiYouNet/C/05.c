#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int a[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int b, c;
    for (int i = 0; i < 5; i++)
    {
        b = a[i];
        a[i] = a[9 - i];
        a[9 - i] = b;
    }
    for (int j = 0; j < 10; j++)
        printf("%d\n", a[j]);
    system("pause");
    return 0;
}
