#include <stdio.h>
#include <stdlib.h>
int main()
{
    int i = 2793, a = 8547, b = 567, j = 3985;
    i++;        //i=2794
    a += 2;     //a=8549
    b %= 5;     //b=2
    j += i;     //j=j+i=6779
    b += (++i); //b=2795+2=2797, i=2795
    printf("%d,%d\n", a, b);
    printf("%d,%d\n", i, j);
    system("pause");
    return 0;
}
