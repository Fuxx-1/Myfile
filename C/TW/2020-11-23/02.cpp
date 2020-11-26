#include <stdio.h>
#include <algorithm>

int main(void)
{
    int n;
    scanf("%d", &n);
    int a[1000], b[1000], c[1000];
    for (int j = 0; j < n; j++)
    {
        scanf("%d%d%d", &a[j], &b[j], &c[j]);
    }
    for (int i = 0; i < n; i++)
    {
        int arr[3] = {0, 0, 0};
        if (a[i] > c[i])
        {
            arr[0] = a[i] / 2;
            arr[1] = a[i] / 2 + a[i] % 2;
            arr[2] = c[i];
        }
        else
        {
            arr[0] = c[i] / 2;
            arr[1] = c[i] / 2 + c[i] % 2;
            arr[2] = a[i];
        }
        for (int j = 0; j < b[i]; j++)
        {
            std::sort(arr, arr + 3);
            arr[0]++;
        }
        std::sort(arr, arr + 3);
        printf("%d\n", arr[2]);
    }
    return 0;
}