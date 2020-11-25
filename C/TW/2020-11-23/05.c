#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int x = 1, y = 0;
    scanf("%d", &x);
    for (int i = 2; i < x; i++)
    {
        for (int j = 2; j <= i; j++)
        {
            if (!(i % j))
            {
                if (!(i - j))
                {
                    y = y + i;
                    break;
                }
            }
        }
    }
    printf("%d", y);

    system("pause");
    return 0;
}