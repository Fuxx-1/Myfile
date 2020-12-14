#include <stdio.h>
#include <math.h>
int main(void)
{
    int x, y, t, flag1, flag2, temp1, temp2, count = 0;
    scanf("%d%d", &x, &y);
    for (int i = 2; i <= y / 4; i++)
    {
        for (int j = i + 1; j <= y; j++)
        {
            flag1 = flag2 = 0;
            temp1 = i;
            temp2 = j;
            t = temp1;
            for (int k = 0; 1; k++)
            {
                if (!(t))
                {
                    if (temp2 == x)
                    {
                        flag1 = 1;
                    }
                    break;
                }
                else if (t < x)
                {
                    break;
                }
                else
                {
                    t = temp2 % temp1;
                    temp2 = temp1;
                    temp1 = t;
                }
            }
            for (int k = 2; 1; k++)
            {
                if (k % i == 0 && k % j == 0)
                {
                    if (!(k - y))
                    {
                        flag2 = 1;
                    }
                    break;
                }
                else if (k > y)
                {
                    break;
                }
            }
            if (flag1 && flag2 && i != j)
            {
                count += 2;
            }
            else if (flag1 && flag2)
            {
                count++;
            }
        }
    }
    printf("%d", count);
    return 0;
}