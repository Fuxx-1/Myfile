#include <stdio.h>
#include <string.h>
int main(void)
{
    char a;
    int count = 0;
    while (scanf("%c", &a) != EOF)
    {
        int b[26] = {1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4};
        if (a != ' ' && a <= 'z' && a >= 'a')
        {
            count += b[a - 'a'];
        }
        else if (a == ' ')
        {
            count++;
        }
    }
    printf("%d", count);
    return 0;
}
