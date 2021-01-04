#include <stdio.h>
#include <algorithm>
int a[1000000], b[1000000];
int main(void)
{
    int n, m, count, min, val = 0;
    scanf("%d%d", &n, &m);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < m; i++)
    {
        scanf("%d", &b[i]);
    }
    std::sort(a, a + n);
    std::sort(b, b + m);
    int i = 0, j = 0;
    while (i < n)
    {
        while (j < m)
        {
            if (a[i] >= b[j] && a[i] <= b[j + 1])
            {
                val += (a[i] - b[j] > b[j + 1] - a[i] ? (b[j + 1] - a[i]) : (a[i] - b[j]));
                break;
            }
            else if (a[i] < b[j])
            {
                val += b[j] - a[i];
                break;
            }
            else if (j - m - 1)
            {
                j++;
            }
            else
            {
                val += a[i] - b[j];
                break;
            }
        }
        printf("%d %d\n", a[i], b[j]);
        i++;
    }
    printf("%d", val);
    return 0;
}