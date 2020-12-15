#include <stdio.h>
int main()
{
    int n, a[30], left = 0, right = 0, flag1 = 1, flag2 = 1;
    scanf("%d", &n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < n; i++)
    {
        if (a[left] && flag1)
        {
            left++;
        }
        else
        {
            flag1 = 0;
        }
        if (a[n - right - 1] && flag2)
        {
            right++;
        }
        else
        {
            flag2 = 0;
        }
        
    }
    if (left % 2)
    {
        printf("YES\n");
    }
    else if (right % 2)
    {
        printf("YES\n");
    }
    else
    {
        printf("NO\n");
    }
    return 0;
}