#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int m;
    scanf("%d", &m);
    double t[m], n[m], s[m], r[m], k[m];
    for (int i = 0; i < m; i++)
    {
        scanf("%lf", &t[i]); //ÿ��һ����ҪT��
        scanf("%lf", &n[i]); //ÿ�޻�Զ������N���˺�
        scanf("%lf", &s[i]); //ÿ��ʹ����Rage��ŭ��ֵ�����S
        scanf("%lf", &r[i]); //ÿ����Rage��ŭ��ֵ��������R
        scanf("%lf", &k[i]); //��Ԫ�����ظ�K�롣
    }
    for (int i = 0; i < m; i++)
    {
        double times = 0.0;
        double time = 0.0;
        double hp = 100.0;
        double rage = 0.0;
        double time_2 = 0.0;

        for (; 1;)
        {
            if (times < 5)
            {
                hp -= n[i];
                times++;
                rage += s[i];
                time += t[i];
            }
            else if (times == 5)
            {
                hp -= (1.5 * n[i]);
                rage += s[i];
            }
            else if (times >= 5)
            {
                times -= 6;
                time += k[i];
            }
            /* hp�ж� */
            while (time - time_2 >= 5)
            {
                rage += r[i];
                time_2 += 5;
            }
            /* ŭ��ֵ�ж� */
            if (rage >= 60)
            {
                printf("�����˲�����£�������Ӯ��\n");
                break;
            }
            else if (hp <= 0 && rage < 60)
            {
                printf("����û���䣬����Ӯ��\n");
                break;
            }
        }
    }

    system("pause");
    return 0;
}