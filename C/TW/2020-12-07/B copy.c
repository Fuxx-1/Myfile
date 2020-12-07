#include <stdio.h>
int main()
{
    char a[65010];
    for (int i = 0;; i++)
    {
        scanf("%c", &a[i]);
        if (a[i] == 'E')
        {
            break;
        }
    }
    int m = 0, n = 0;
    for (int j = 1; a[j] != 'E'; j++)
    {
        if (a[j] == 'W')
        {
            m++;
            if (m >= 11 && m - n >= 2)
            {
                printf("%d:%d\n", m, n);
                m = 0;
                n = 0;
            }
        }
        else if (a[j] == 'L')
        {
            n++;
            if (n >= 11 && n - m >= 2)
            {
                printf("%d:%d\n", m, n);
                m = 0;
                n = 0;
            }
        }
    }
    printf("adkjhflakjfaljfaldkfjasf");
    printf("%d:%d\n", m, n);
    printf("\n");
    m = 0;
    n = 0;
    for (int j = 1; a[j] != 'E'; j++)
    {

        if (a[j] == 'W')
        {
            m++;
            if (m >= 21 && m - n >= 2)
            {
                printf("%d:%d\n", m, n);
                m = 0;
                n = 0;
            }
        }
        else if (a[j] == 'L')
        {
            n++;
            if (n >= 21 && n - m >= 2)
            {
                printf("%d:%d\n", m, n);
                m = 0;
                n = 0;
            }
        }
    }
    printf("%d:%d\n", m, n);
    return 0;
}