#include <stdio.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    int ans, flag;
    int a[2000];
    char str[2000][50];
    char bin = getchar();
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
        bin = getchar();
        gets(&str[i][0]);
    }
    for (int i = 0; i < n; i++)
    {
        ans = 0, flag = -1;
        for (int j = 0; j < a[i]; j++)
        {
            if (str[i][j] == '(')
            {
                for (int k = j; k < a[i]; k++)
                {
                    if (str[i][k] == ')' && k > flag)
                    {
                        flag = k;
                        break;
                    }
                    else if (k + 1 == a[i])
                    {
                        ans++;
                    }  
                }
            }
            else if (str[i][j] == ')' && j > flag)
            {
                ans++;
            }
        }
        printf("%d\n", ans / 2);
    }
    
    
    return 0;
}