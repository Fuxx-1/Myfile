#include <stdio.h>
#include <stdlib.h>

void sort(int arr[], int len)
{
    int i, j, temp;
    for (i = 0; i < len - 1; i++)
        for (j = 0; j < len - 1 - i; j++)
            if (arr[j] > arr[j + 1])
            {
                temp = arr[j];
                arr[j] = arr[j + 1];    //交换位置
                arr[j + 1] = temp;
            }
}

int main(void)
{
    /* 随机64个数 */
    int n = 1000;
    srand((time(NULL)));
    int a[64];
    for(int i = 0; i < 64; i++)
        a[i] = rand() % n;


    system("pause");
    return 0;
}