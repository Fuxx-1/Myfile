#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int i, j, temp, back = 1;
    do
    {
        int a[10] = {0};
        printf("请输入想找最大数的十个数字（用','连接）：\n");
        scanf("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d", &a[0], &a[1], &a[2], &a[3], &a[4], &a[5], &a[6], &a[7], &a[8], &a[9]);
        /* 非循环式取值，取十个值 */
        for (i = 0; i < 9; i++)
            for (j = 0; j < 9 - i; j++)
                if (a[j] > a[j + 1])
                {
                    temp = a[j];
                    a[j] = a[j + 1]; //交换位置
                    a[j + 1] = temp;
                }
        printf("最大的数字是：");
        printf("%d\n", a[9]);
        printf("退出请输入0后确认，不退出请输入任意数字：\n");
        scanf("%d", &back);
    } while (back != 0);

    system("pause");
    return 0;
}