#include <stdio.h>
char pend[100000005];
void count()
{
    int count = 1;
    /* 定义 */
    pend[1] = 1;    //特判
    for (int i = 2; i * i <= 100005; i++)
    {
        if (!pend[i])
        {
            for (int j = i * i; j <= 100005; j += i)
            {
                pend[j] = 1;
            }
        }
    }
    /* 线筛 */
    return;
}
int main(void)
{
    count();
    int a[105], n;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < n; i++)
    {
        if (!pend[a[i]])
        {
            printf("%d ", a[i]);
        }
    }
    return 0;
}