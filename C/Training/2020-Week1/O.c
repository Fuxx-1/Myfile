#include <stdio.h>
#include <string.h>
int Sta(char a[], char b)
{
    int ans = 0;
    int temp = strlen(a);
    while (temp--)
    {
        if (a[temp] == b)
            ans++;
    }
    return ans;
}
int main(void)
{
    char a[200];
    int b;
    scanf("%d", &b);
    char bin = getchar();
    while (b--)
    {
        gets(a);
        printf("a:%d\n", Sta(a, 'a'));
        printf("e:%d\n", Sta(a, 'e'));
        printf("i:%d\n", Sta(a, 'i'));
        printf("o:%d\n", Sta(a, 'o'));
        if (b)
            printf("u:%d\n\n", Sta(a, 'u'));
        else
            printf("u:%d\n", Sta(a, 'u'));
    }
    return 0;
}