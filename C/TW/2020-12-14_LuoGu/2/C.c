#include <stdio.h>
#include <math.h>
#include <string.h>
int main(void)
{
    int val1, val2, val = 0;
    char num[50];
    scanf("%d", &val1);
    scanf("%s", &num);
    scanf("%d", &val2);
    int n = strlen(num) - 1;
    for (int i = 0; i < strlen(num); i++)
    {
        if (num[i] >= 'A')
        {
            val += pow(val1, n) * (num[i] - 'A' + 10);
        }
        else
        {
            val += pow(val1, n) * (num[i] - '0');
        }
        n--;
    }
    for (int i = 0; 1; i++)
    {
        if (val / pow(val2, i) <= 1)
        {
            n = i;
            break;
        }
    }
    char a[50];
    for (int i = 0; i < n; i++)
    {
        a[i] = (int)(val / pow(val2, n - i - 1)) % val2;
        if (a[i] >= 10)
        {
            a[i] = a[i] - 10 + 'A';
        }
        else
        {
            a[i] = a[i] + '0';
        }
    }
    for (int i = 0; i < n; i++)
    {
        printf("%c", a[i]);
    }
    return 0;
}