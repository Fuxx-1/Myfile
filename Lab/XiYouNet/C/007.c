#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int b;
    scanf("%d", &b);
    int a[8] = {1, 2, 3, 15, 19, 20, 41, 55};
    int min = 0, max = 7;
    for (int r = 0; r <= 3; r++)
    {
        int mid = (min + max) / 2;
        if (a[mid] < b)
            min = mid;
        else (a[mid] > b)
            max = mid;         
    }
    printf("%d\n", mid);
    system("pause");
    return 0;
}