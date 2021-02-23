#include <stdio.h>
int main(void)
{
    int a, flag = 1;
    scanf("%d", &a);
    for (int i = 0; i <= a / 5; i++)
    {
        for (int j = 0; j <= (a - i * 5) / 3; j++)
        {
            if (i + j + (a - i * 5 - j * 3) * 3 == a)
            {
                printf("%d %d %d\n", i, j, a - i - j);
                flag = 0;
            }
        }
    }
    if (flag)
    {
        printf("No Answer.\n");
    }
    return 0;
}