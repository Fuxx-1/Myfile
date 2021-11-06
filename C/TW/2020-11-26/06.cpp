// #include <stdio.h>
// #include <algorithm>
// int main(void)
// {
//     int n;
//     scanf("%d", &n);
//     int a[n];
//     for (int i = 0; i < n; i++)
//     {
//         scanf("%d", &a[i]);
//     }
//     std::sort(a, a + n);
//     printf("%d", a[n - 1] - a[0]);
//     return 0;
// }
#include<stdio.h>
#include <algorithm>
int main(void)
{
    int a;
    scanf("%d", &a);
    int b[a];
    for (int i = 0; i < a; i++) {
        scanf("%d", &b[i]);
    }
    std::sort(b, b+a);
    for (int i = 0; i < a; i++) {
        printf("%d ", b[i]);
    }
    return 0;
}