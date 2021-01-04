#include <stdio.h>
#include <stdlib.h>
int binary_search(int key, int a[], int n)
{
    int l = 0, r = n - 1, mid;
    while (l <= r)
    {
        int mid = l + (r - l) / 2; //�������
        if (a[mid] == key)
        {
            printf("%d\n", mid); //��ӡҪ����Ԫ�ص�λ��
            break;
        }
        if (key > a[mid])
            l = mid + 1;
        else
            r = mid - 1;
    }
    return 0;
}

int main()
{
    int i, a[100], n, key;
    printf("���������鳤�ȣ�\n");
    scanf("%d", &n);
    printf("����������Ԫ�أ�\n");
    for (i = 0; i < n; i++)
        scanf("%d", &a[i]);
    printf("������������ҵ�Ԫ�أ�\n");
    scanf("%d", &key);
    binary_search(key, a, n);
    printf("\n");
    system("pause");
    return 0;
}