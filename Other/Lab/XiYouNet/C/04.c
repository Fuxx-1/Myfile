#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int i, j, temp, back = 1;
    do
    {
        int a[10] = {0};
        printf("�����������������ʮ�����֣���','���ӣ���\n");
        scanf("%d,%d,%d,%d,%d,%d,%d,%d,%d,%d", &a[0], &a[1], &a[2], &a[3], &a[4], &a[5], &a[6], &a[7], &a[8], &a[9]);
        /* ��ѭ��ʽȡֵ��ȡʮ��ֵ */
        for (i = 0; i < 9; i++)
            for (j = 0; j < 9 - i; j++)
                if (a[j] > a[j + 1])
                {
                    temp = a[j];
                    a[j] = a[j + 1]; //����λ��
                    a[j + 1] = temp;
                }
        printf("���������ǣ�");
        printf("%d\n", a[9]);
        printf("�˳�������0��ȷ�ϣ����˳��������������֣�\n");
        scanf("%d", &back);
    } while (back != 0);

    system("pause");
    return 0;
}