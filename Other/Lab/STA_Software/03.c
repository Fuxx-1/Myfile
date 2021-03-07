#include <stdio.h>
//#include <stdlib.h>
int main()
{
    int a = 1, b = 2;
    if (!a && b-- || a && b-- || a++ && b++)
    {
        printf("%d\n", a);
        return 0;
      //  system("pause");
    }
    printf("%d\n", b);
    //system("pause");
    return 0;
}