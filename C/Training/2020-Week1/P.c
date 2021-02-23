#include <stdio.h>
#include <math.h>
int main(void)
{
    int m, n;
    float l, ans;
    while (scanf("%d", &m) != EOF)
    {
        scanf("%d", &n);
        l = m / 1.0;
        ans = 0;
        while (n--)
        {
            ans += l;
            l = sqrt(l);
        }
        printf("%.2f\n", ans);
    }
    return 0;
}