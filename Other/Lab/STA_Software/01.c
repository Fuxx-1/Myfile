/*
1.回味高考
北京天坛的圜丘坛为古代祭天的场所，分上、中、下三层，上层中心有一块石板（称为天心石），
环绕天心石砌9块.扇面形石板构成第一环，向外每环依次增加9块，下一-层的第一环比_上一层
的最后一环多9块，向外每环依次也增加9块，已知每层环数相同，且下层比中层多729块，则三层
共有扇面形石板（不含天心石多少块？请编程解决此题。
*/
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int i_1 = 1, i_2 = 0, i_3 = 0;
    int differ = i_3 - i_2;
    for (int b = 1; differ != 729; ++b)
    {
        i_1 = 0, i_2 = 0, i_3 = 0;
        for (int a = 1; a <= b; a++)
            i_1 = a * 9 + i_1;
        for (int a = 1; a <= b; a++)
            i_2 = (a + b) * 9 + i_2;
        for (int a = 1; a <= b; a++)
            i_3 = (a + 2 * b) * 9 + i_3;
        differ = i_3 - i_2;
    }
    printf("%d\n", i_1 + i_2 + i_3);
    printf("%d\n", i_1);

    system("pause");
    return 0;
}