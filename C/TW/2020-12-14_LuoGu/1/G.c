#include <stdio.h>
#include <math.h>
int a[4] = {1, 3, 7, 9};
int n;
int pend(int x)
{
    if (x == 1)
        return 0;
    if (x == 2)
        return 1;
    for (int i = 2; i <= sqrt(x); i++)
        if (x % i == 0)
        {
            return 0;
        }
    return 1;
}
void DFS(int k, int sum)
{
    int p;
    if (!(sum - n))
    {
        printf("%d\n", k);
    }
    else
    {
        for (int i = 0; i < 4; i++)
        {
            p = k * 10 + a[i];
            if (pend(p))
            {
                DFS(p, sum + 1);
            }
        }
    }
}
int main(void)
{
    scanf("%d", &n);
    DFS(2, 1);
    DFS(3, 1);
    DFS(5, 1);
    DFS(7, 1);
    return 0;
}