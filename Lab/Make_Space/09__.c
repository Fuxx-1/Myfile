/*
9.ʵ��������һ���˹�����ϲ�������ף���Щ���װ��մ�С�����˱�ţ�����Ϊ�˲������֣�
	ֻ�ܳ���С���������ף����ܰ����ҳ�����
*/
#include <stdio.h>
int sort(int *arr, int len)
{
	int i, j, temp;
	for (int i = 0; i < len; i++)
	{
		temp = arr[i];
		for (int j = i; j > 0 && arr[j - 1] > temp; j--)
		{
			arr[j] = arr[j - 1];
			arr[j - 1] = temp;
		}
	}
	return 0;
}
int main()
{
	int len = 2;
	int arr[len];
	printf("���׸���");
	scanf("%d", &len);
	for (int i = 0; i < len; i++)
		scanf("%d", &arr[i]);
	sort(arr, len);
	printf("%d,%d", arr[0], arr[1]);
	return 0;
}
