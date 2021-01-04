#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    for (int i = 0; i < 100; i++)
    {
        static int a = 1;
        printf("%d ", a);
        a++;
    }
    
    
    system("pause");
    return 0;
}