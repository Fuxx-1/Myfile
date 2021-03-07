/* 
2.分析以下代码，它的运行结果是
i = 1
 */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    int i = -1;
    if (i = 0)
        printf("i = %d\n", i);
    else if (i = 1)
        printf("i = %d\n", i);
    else
        printf("i = %d\n", i);

    system("pause");
    return 0;
}
