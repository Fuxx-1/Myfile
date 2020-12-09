#include <stdio.h>
int main(void)
{
    char str[14];
    scanf("%s", str);
    int val = 0;
    val += (str[0] - '0') * 1;
    val += (str[2] - '0') * 2;
    val += (str[3] - '0') * 3;
    val += (str[4] - '0') * 4;
    val += (str[6] - '0') * 5;
    val += (str[7] - '0') * 6;
    val += (str[8] - '0') * 7;
    val += (str[9] - '0') * 8;
    val += (str[10] - '0') * 9;
    val = val % 11;
    if (!(val - 10))
        val = 'X';
    if (val != 'X')
    {
        if ((str[12] - '0') == val)
        {
            printf("Right");
        }
        else
        {
            str[12] = val + '0';
            printf("%s", str);
        }
    }
    else
    {
        if (str[12] == 'X')
        {
            printf("Right");
        }
        else
        {
            str[12] = 'X';
            printf("%s", str);
        }
    }
    return 0;
}