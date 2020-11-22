#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int n = 0;
    int e = 0;
    scanf("%d", &n);
    int a[n];
    for (int s = 0; s < n; s++)
    {
        scanf("%d", &a[s]);
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            if (!(a[i] - a[j]))
            {
                if (i < j)
                {
                    e += 1;
                }
            }
        }
    }
    printf("%d\n", e);

    system("pause");
    return 0;
}