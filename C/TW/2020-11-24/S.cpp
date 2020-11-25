#include <algorithm>
#include <stdio.h>
int main(void)
{
    int n;
    while (scanf("%d", &n) != EOF)
    {
        int a[100000];
        for (int i = 0; i < n; i++)
        {
            scanf("%d", &a[i]);
        }
        std::sort(a, a + n);
        int sum = 0;
        for (int i = 1; i < n - 1; i++)
        {
            sum += a[i];
        }
        double out = (double)sum / (n - 2);
        printf("%.2f", out);
    }
    return 0;
}