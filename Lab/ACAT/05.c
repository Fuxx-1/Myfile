/* 
5.��w=1,x=2,y=3,z=4,���������ʽw<x? w:y<z? y:z��ֵ�ǣ� ��
A: 4
B: 3
C: 2
D: 1

[��]
D
[����]


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