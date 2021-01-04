#include <stdio.h>
#include <string.h>
int count = 0;
char str[5001];
int solve(char a, int b)
{
    if (a <= b)
    {
        if (str[a] == str[b])
        {
            a++;
            b--;
        }
        else if (str[a] != str[b])
        {
            if (str[a] == str[b - 1])
            {
                count++;
                b--;
            }
            else if (str[a + 1] == str[b])
            {
                count++;
                a++;
            }
            else
            {
                count += 2;
                b--;
                a++;
            }
        }
        return solve(a, b);
    }
    else
    {
        return count;
    }
}
int main(void)
{
    int n, count;
    scanf("%d", &n);
    char bin = getchar();
    gets(str);
    // n = strlen(str);
    printf("%d\n", solve(0, n - 1));
    return 0;
}
