#include <stdio.h>
#include <math.h>
int Ave(int a[], int n)
{ //平均
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        count += a[i];
    }
    return count / n;
}
int OddElements(int a[], int n)
{ //奇数个数
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        if (a[i] % 2)
        {
            count++;
        }
    }
    return count;
}
int Arraynum(int a[], int n)
{ //奇数下标且为奇数之和
    int count = 0;
    for (int i = 0; i < n; i++)
    {
        if (a[i] % 2 && i % 2)
        {
            count += a[i];
        }
    }
    return count;
}
int Totfc(int a[], int n)
{ //方差
    int Tot, ave = Ave(a, n);
    for (int i = 0; i < n; i++)
    {
        Tot += pow((a[i] - ave), 2);
    }
    return Tot / n;
}
void Out(int a[], int n, int k)
{ //输出K圈
    for (int i = 0; i < k; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (n - j - 1)
            {
                printf("%d ", a[j]);
            }
            else
            {
                printf("%d\n", a[j]);
            }
        }
    }
    return;
}
int main(void)
{
    int a[6] = {1, 2, 3, 4, 5, 6};
    int n = sizeof(a) / sizeof(a[0]);
    int k = 0;
    printf("k = ");
    scanf("%d", &k);
    printf("----------分割线-----------\n");
    printf("奇数的个数：%d\n", OddElements(a, n));
    printf("----------分割线-----------\n");
    printf("下标为奇数，值为奇数的元素之和：%d\n", Arraynum(a, n));
    printf("----------分割线-----------\n");
    printf("所有元素的方差：%d\n", Totfc(a, n));
    printf("----------分割线-----------\n输出k圈：\n");
    Out(a, n, k);
    return 0;
}