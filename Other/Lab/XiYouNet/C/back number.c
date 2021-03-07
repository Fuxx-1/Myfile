#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int a, b;
    scanf("%d%d", &a, &b);
    if (b > a)
    {
        int temp;
        temp = a;
        a = b;
        b = temp;
    }
    for (int i = 1; i >= 1; i++)
    {
        int c ;
        c = a % b;
        if (!(c))
        {
            break;
        }
        a = b;
        b = c;
    }
    printf("%d\n", b);

    system("pause");
    return 0;
}