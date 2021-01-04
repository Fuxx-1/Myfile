/* 
5.若w=1,x=2,y=3,z=4,则条件表达式w<x? w:y<z? y:z的值是（ ）
A: 4
B: 3
C: 2
D: 1

[答案]
D
[解析]


 */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int w=1, x=2, y=3, z=4;
    printf("%d\n", (w<x? w:y<z? y:z));

    system("pause");
    return 0;
}