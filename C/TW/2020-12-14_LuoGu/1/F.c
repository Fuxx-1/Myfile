#include <stdio.h>
int main(void)
{
    int flag, n, a = 2, count = 0;
    scanf("%d", &n);
    while (a <= n)
    {
        flag = 0;
        for (int i = 2; i * i <= a; i++)
        {
            if (!(a % i))
            {
                flag = 0;
                break;
            }
            flag = 1;
        }
        if (flag || a == 2 || a == 3)
            count++;
        a++;
    }
    printf("%d", count);
    return 0;
}