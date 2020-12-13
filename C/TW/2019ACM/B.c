#include <stdio.h>
int main(void)
{
    long long int val, n = 1, num = 0;
    scanf("%lld", &val);
    for (int i = 0; 1; i++)
    {
        num += n * n;
        val -= n;
        if (val <= 0)
        {
            num += val * n;
            break;
        }
        else
        {
            n++;
        }
    }
    printf("%lld", num);
    return 0;
}