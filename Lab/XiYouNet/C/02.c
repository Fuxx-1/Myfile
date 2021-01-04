#include <stdio.h>
#include <stdlib.h>
int main()
{
    int a[3][3] = {{2}, {4}, {6}};
    int i, *p = &a[0][0];
    for (i = 0; i < 2; i++)
    {
        if (i == 0)
            // a[i][i + 1] = *p;
            // a[i][i + 1] = *p[0]+1;
            // a[i][i + 1] = *p+1;      //¡Ì
            a[i][i + 1] = *(p+1);
        else
            ++p;
        printf("%p ", *p);
        printf("%p\n", (p+1));
        printf("%p\n", &a[1][0]);
        printf("%p\n", &a[0][1]);
    }
    printf("\n");
    int c = 1;
    printf("%p", &c);
    system("pause");
    return 0;
}
/* 
A.2 2
B.2 2
C.2 3   ¡Ì
D.2 0
*/