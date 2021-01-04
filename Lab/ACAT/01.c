/* 
1.现在#define M y*y+3*y，令s=3*M+4*M+5*M,请求出s=s(y)的表达式。
s = 3 * y * y + 3 * y + 4 * y * y + 3 * y + 5 * y * y + 3 * y
 */
#include <stdio.h>
#include <stdlib.h>

#define M "y * y + 3 * y"

int main(void)
{
    printf("s = 3 * %s + 4 * %s + 5 * %s\n", M, M, M);

    system("pause");
    return 0;
}