#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int a[7] = {1, 2, 3, 4, 5, 6, 7};
    int temp;
    for (int i = 0; i <= 3; i++)
    {
        temp = a[i];
        a[i] = a[6 - i];
        a[6 - i] = temp;
    }
    for (int b = 0; b <= 6; b++)
        printf("%d ", a[b]);
    system("pause");
    return 0;
}