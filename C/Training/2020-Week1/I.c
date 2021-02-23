#include <stdio.h>
int main(void)
{
    char a[10];
    char b[10];
    gets(a);
    gets(b);
    int h = (a[0] - '0') * 10 + (a[1] - '0') - (b[0] - '0') * 10 - (b[1] - '0');
    int m = (a[3] - '0') * 10 + (a[4] - '0') - (b[3] - '0') * 10 - (b[4] - '0');
    int s = (a[6] - '0') * 10 + (a[7] - '0') - (b[6] - '0') * 10 - (b[7] - '0');
    printf("%d", h * 60 * 60 + m * 60 + s);
    return 0;
}