/* 
2.int x=5,y=2,z=1; 
++x + y
z+y++
x+y
执行语句 printf(“%x”,-1);屏幕显示什么？
*/
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int x = 5, y = 2, z = 2;
    ++x + y;
    z + y++;
    x + y;

    /*
    以上代码无用
    */

    printf("%x", -1); //Question

    printf("\n");

    system("pause");
    return 0;
}