#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    for(int i = 100; i < 1000; i++)
    {
        int a = i % 10;
        int b = (i / 10) % 10;
        int c = i / 100;
        if(!(i-a*a*a-b*b*b-c*c*c))
            printf("%d\n", i);
    }
    system("pause");
    return 0;
}