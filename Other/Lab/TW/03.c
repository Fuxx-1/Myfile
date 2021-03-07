#include <stdio.h>
#include <stdlib.h>
int main()
{
    int a[5][5] = {0, 1, 2, 3, 4, 5, 6, 7};
    printf("%d\n%d\n%d\n%d\n%d\n%d\n", a, &a, &a[0], *a[1], *(*(a + 1) + 2), *(a[3] + 3));
    
    /* 
6422204
6422204
6422204
5
7
0
 */
    system("pause");
    return 0;
}