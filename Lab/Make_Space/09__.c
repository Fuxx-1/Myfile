/*
9.实验室里有一个菜狗，他喜欢啃玉米，这些玉米按照大小进行了标号，而他为了不被发现，
	只能吃最小的两个玉米，你能帮他找出来吗？
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
	printf("玉米个数");
	scanf("%d", &len);
	for (int i = 0; i < len; i++)
		scanf("%d", &arr[i]);
	sort(arr, len);
	printf("%d,%d", arr[0], arr[1]);
	return 0;
}
