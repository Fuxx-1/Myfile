#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    char d;
    do
    {
        int b = 0;
        printf("请输入数字个数：\n");
        scanf("%d", &b);
        int a[b];
        printf("请输入数字：\n");
        for (int num = 0; num < b; num++)
        {
            scanf("%d", &a[num]);
        }
        int m = a[0], count = 0;
        for (int i = 0; i < b; i++)
        {
            if (a[i] == m)
                count++;
            else
            {
                if (count > 0)
                    count--;
                else
                {
                    m = a[i];
                    count = 1;
                }
            }
        }
        count = 0;
        for (int i = 0; i < b; i++)
        {
            if (a[i] == m)
                count++;
        }
        printf("主要元素：\n");
        if (count > b / 2)
            printf("%d\n", m);
        else
            printf("-1\n");
        printf("是否继续(1/0)?\n");
        scanf("%d", &d);
    } while (d == 'Y');

    system("pause");
    return 0;
}
