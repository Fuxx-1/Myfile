#include <stdio.h>
int main(void)
{
    int a[100];
    int num;
    int old, new;
    int i, j;
    while (scanf("%d", &num) != EOF)
    {
        i = 1;
        a[0] = num;
        while (1)
        {
            old = num;
            new = 0;
            while (num > 0)
            {
                new = new * 10 + (num % 10);
                num /= 10;
            }
            if (new == old)
            {
                break;
            }
            else
            {
                num = old + new;
                a[i++] = num;
            }
        }
        printf("%d\n", i - 1);
        for (j = 0; j < i - 1; j++)
            printf("%d--->", a[j]);
        printf("%d\n", a[i - 1]);
    }
    return 0;
}