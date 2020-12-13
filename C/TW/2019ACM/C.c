#include <stdio.h>
int main(void)
{
    int t, b[110];
    scanf("%d", &t);
    for (int i = 0; i < t; i++)
    {
        int n;
        scanf("%d", &n);
        int count = 0;
        for (int j = n; j > 0;)
        {
            j /= 2;
            count++;
        }
        b[i] = count;
    }
    for (int i = 0; i < t; i++)
    {
        printf("%d\n", b[i]);
    }

    return 0;
}