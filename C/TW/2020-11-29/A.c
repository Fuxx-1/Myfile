#include <stdio.h>
int main(void)
{
    int a[10000];
    int count = 0, val1, val2, val3;
    int num1, num2, num3;
    for (int i = 0; 1; i++)
    {
        scanf("%d", &a[i]);
        if (a[i] == 0)
        {
            break;
        }
        count++;
    }
    for (int i = 0; i < count; i++)
    {
        val1 = val2 = val3 = 0;
        num1 = num2 = num3 = 1; 
        for (int j = 0; 1; j++)
        {
            val1 += a[i] / num1 % 10;
            val2 += a[i] / num2 % 12;
            val3 += a[i] / num3 % 16;
            num1 *= 10;
            num2 *= 12;
            num3 *= 16;
            if (a[i] / num1 == 0 && a[i] / num2 == 0)
            {
                break;
            }
        }
        if (val1 == val2 && val2 == val3)
        {
            printf("%d is a Sky Number.\n", a[i]);
        }
        else
        {
            printf("%d is not a Sky Number.\n", a[i]);
        }
    }
    return 0;
}