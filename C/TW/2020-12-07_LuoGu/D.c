#include <stdio.h>
int a[1000000];
int main(void)
{
    int n, m;
    scanf("%d%d", &n, &m);
    int b[100000];
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }
    for (int i = 0; i < m; i++)
    {
        scanf("%d", &b[i]);
    }
    int low, high, mid;
    int i = 0;
    while (m--)
    {
        low = 1, high = n;
        while (low < high)
        {
            mid = (low + high - 1) / 2;
            if (a[mid] >= b[i])
            {
                high = mid;
            }
            else if (a[mid] < b[i])
            {
                low = mid + 1;
            }
            if (a[low] == b[i])
            {
                break;
            }
        }
        if (!(a[low] - b[i]))
        {
            printf("%d ", mid + 1);
        }
        else
        {
            printf("-1 ");
        }
        i++;
    }
    return 0;
}

// #include <stdio.h>
// int binarySearch(int array[], int length, int key)
// {
//     int low = 1, mid;
//     int high = length;
//     while (low < high)
//     {
//         mid = (low + high - 1) / 2;
//         if (key <= array[mid])
//             high = mid;
//         if (key > array[mid])
//             low = mid + 1;
//         if (key == array[low])
//             return low;
//     }
//     return -1;
// }
// int main()
// {
//     int n, x, i, j, y;
//     scanf("%d %d", &n, &x);
//     int arr[n], a[x];
//     for (i = 1; i <= n; i++)
//     {
//         scanf("%d", &arr[i]);
//     }
//     for (i = 1; i <= x; i++)
//     {
//         scanf("%d", &a[i]); //要查找的元素
//     }
//     for (i = 1; i <= x; i++)
//     {
//         int index = binarySearch(arr, n, a[i]);
//         printf("%d", index);
//         if (i <= x - 1)
//             printf(" ");
//     }
//     return 0;
// }  