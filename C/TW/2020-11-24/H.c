#include <stdio.h>
int main(void)
{
    int num;
    scanf("%d", &num);
    int n = 0, sum = 0;
    for (int j = 0; j < num; j++)
    {
        scanf("%d", &n);
        if (n)
        {
            int a[100000];
            for (int i = 0; i < n; i++)
            {
                scanf("%d", &a[i]);
            }
            for (int i = 1; i < n; i++)
            {
                a[0] += a[i];
            }
            printf("%d\n", a[0]);
        }
        else
            break;
        printf("\n");
    }
    return 0;
}