#include <stdio.h>
#include <string.h>
int main(void)
{
    int n;
    scanf("%d", &n);
    char a[60];
    scanf("%s", &a);
    int m = strlen(a);
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (a[j] == 'z')
            {
                a[j] = 'a';
            }
            else if (a[j] == 'Z')
            {
                a[j] = 'A';
            }
            else
            {
                a[j]++;
            }
        }
    }
    puts(a);
    return 0;
}