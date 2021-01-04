#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int len;
    printf("输入长度：\n");
    scanf("%d", &len);
    int a[len];
    printf("输入数字：\n");
    for(int i_1 = 0; i_1 <= len - 1; i_1++)
        scanf("%d", &a[i_1]);
    /* 输入 */
    int i, j, temp;
    for (i = 0; i < len - 1; i++)
        for (j = 0; j < len - 1 - i; j++)
            if (a[j] > a[j + 1])
            {
                temp = a[j];
                a[j] = a[j + 1]; //交换位置
                a[j + 1] = temp;
            }
    /* 排序 */
    for (int i = 0; i <= len - 1; i++)
    {
        printf("%d\n", a[i]);
    }
    /* 输出 */
    system("pause");
    return 0;
}