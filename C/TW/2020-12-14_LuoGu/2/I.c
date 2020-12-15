#include <stdio.h>
int main()
{
    int t, val;
    scanf("%d", &t);
    while (t--)
    {
        scanf("%d", &val);
        printf("%s", (val % 4) ? "October wins!\n" : "Roy wins!\n");
    }
    return 0;
}