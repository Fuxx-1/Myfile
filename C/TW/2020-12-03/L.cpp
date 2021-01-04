#include <stdio.h>
#include <algorithm>
#include <string.h>
int main(void)
{
    int n, count = 0, t;
    scanf("%d", &n);
    int a[10000], temp[3];
    int ans[10000][3];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = i + 1; j < n; j++)
        {
            for (int k = j + 1; k < n; k++)
            {
                if (a[i] + a[j] + a[k] == 0)
                {
                    ans[count][0] = a[i];
                    ans[count][1] = a[j];
                    ans[count][2] = a[k];
                    count++;
                }
            }
        }
    }
    for (int i = 0; i <= count; i++)
    {
        std::sort(&ans[i][0], &ans[i][0] + 3);
    }

    for (int i = 0; i < count; i++)
    {
        for (int j = 0; j < count; j++)
        {
            if (ans[i][0] < ans[j][0])
            {
                for (int k = 0; k < 3; k++)
                {
                    t = ans[i][k];
                    ans[i][k] = ans[j][k];
                    ans[j][k] = t;
                }
            }
        }
    }
    for (int i = 0; i < count; i++)
    {
        for (int j = 0; j < count; j++)
        {
            if (ans[i][0] == ans[j][0] && ans[i][1] < ans[j][1])
            {
                for (int k = 0; k < 3; k++)
                {
                    t = ans[i][k];
                    ans[i][k] = ans[j][k];
                    ans[j][k] = t;
                }
            }
        }
    }
    for (int i = 0; i < count; i++)
    {
        for (int j = 0; j < count; j++)
        {
            if (ans[i][0] == ans[j][0] && ans[i][1] == ans[j][1] && ans[i][2] < ans[j][2])
            {
                for (int k = 0; k < 3; k++)
                {
                    t = ans[i][k];
                    ans[i][k] = ans[j][k];
                    ans[j][k] = t;
                }
            }
        }
    }

    for (int i = 0; i < count; i++)
    {
        if (ans[i][0] != ans[i - 1][0] || ans[i][1] != ans[i - 1][1] || ans[i][2] != ans[i - 1][2] || i == 0)
        {
            printf("%d %d %d\n", ans[i][0], ans[i][1], ans[i][2]);
        }
    }
    if (!count)
    {
        printf("No Solution\n");
    }
    
    return 0;
}