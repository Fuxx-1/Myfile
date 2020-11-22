#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    double t, n, s, r, k;
    scanf("%d", &t);
    scanf("%d", &n);
    scanf("%d", &s);
    scanf("%d", &r);
    scanf("%d", &k);
    int time = 0;
    int HP = 100;
    int Rage = 0;
    int K = 0;
    int H = 0;
    for (int i = 0; i = 1; i++)
    {
        if (k == 0 && time % (int)t == 0)
        {
            HP -= n;
            H++;
            if (!(H - 5))
            {
                K = k;
                H = 0;
            }
            
        }
        
        if(Rage > 60)
        {
            printf("年轻人不讲武德，年轻人赢了\n");
            break;
        }
        if (!(time % 5))
        {
            Rage += 1;
        }

        time += 1;
    }
    printf("马老没有输，马老赢了\n");


    system("pause");
    return 0;
}