#include <stdio.h>
char a[30];
int n, x, y, i, temp;
void Del(char b)
{
    i = 0;
    while (a[i] != 0 && y)
    {
        if (a[i] == b && y)
        {
            temp = i;
            while (a[temp] != 0)
            {
                a[temp] = a[temp + 1];
                temp++;
            }
            y--;
        }
        else
        {
            i++;
        }
    }
    return;
}
void Sol()
{
    Del('9');
    Del('8');
    Del('7');
    Del('6');
    Del('5');
    Del('4');
    Del('3');
    Del('2');
    Del('1');
    printf("%s\n", a);
    return;
}
int main(void)
{
    scanf("%d", &n);
    while (n--)
    {
        scanf("%s %d", a, &y);
        Sol();
    }
    return 0;
}