#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    char d;
    do
    {
        int b = 0;
        printf("���������ָ�����\n");
        scanf("%d", &b);
        int a[b];
        printf("���������֣�\n");
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
        printf("��ҪԪ�أ�\n");
        if (count > b / 2)
            printf("%d\n", m);
        else
            printf("-1\n");
        printf("�Ƿ����(1/0)?\n");
        scanf("%d", &d);
    } while (d == 'Y');

    system("pause");
    return 0;
}
