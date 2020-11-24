#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int m;
    scanf("%d", &m);
    double t[m], n[m], s[m], r[m], k[m];
    for (int i = 0; i < m; i++)
    {
        scanf("%lf", &t[i]); //每打一鞭需要T秒
        scanf("%lf", &n[i]); //每鞭会对对手造成N点伤害
        scanf("%lf", &s[i]); //每鞭使对手Rage（怒气值）提高S
        scanf("%lf", &r[i]); //每五秒Rage（怒气值）会增长R
        scanf("%lf", &k[i]); //混元功法回复K秒。
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
            /* hp判断 */
            while (time - time_2 >= 5)
            {
                rage += r[i];
                time_2 += 5;
            }
            /* 怒气值判断 */
            if (rage >= 60)
            {
                printf("年轻人不讲武德，年轻人赢了\n");
                break;
            }
            else if (hp <= 0 && rage < 60)
            {
                printf("马老没有输，马老赢了\n");
                break;
            }
        }
    }

    system("pause");
    return 0;
}