/* 
9.实现一个函数，输出n行空心的数字金字塔。如：输入5，输出：
 */
#include <stdio.h>
#include <stdlib.h>

#define p1 printf(" ")
#define p2 printf("*")

void ast(int val)
{
    for (int b = 1; b <= val; b++)
    {
        if (!(b - val))
            break;
        for (int i = 0; i < val - b; i++)
        {
            p1;
        }
        /* sp_1 */
        p2;
        /* *_1 */
        for (int i = 0; i < 2 * b - 3; i++)
        {
            p1;
        }
        /* sp_2 */
        if (b != 1)
            p2;
        printf("\n");
    }
    for (int i = 0; i <= (val * 2) - 1; i++)
    {
        if (!((i)%2))
        {
            p2;
        }
        else
        {
            p1;
        }
    }
    printf("\n");
    return;
}
int main(void)
{
    int val;
    printf("请输入想要的层数：\n");
    scanf("%d", &val);
    ast(val);

    system("pause");
    return 0;
}