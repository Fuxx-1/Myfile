/*
10.MakerSpaceʵ����������ֻ�������μ���ѧ��ÿ�춼�ᰲ��һ��������ɨ������Ϊ�˹�ƽ�����
  �μ��ӻ�˵��10�����֣���{5,3,5,2,5,5,5,6,5,2}��,������ͬ���ֹ����������Ϊ��ʤ����
  ���������û����ʤ�����������None!��������У����������������������˿��Բ��ô�ɨ������
  ���ҵ����ķ�����������
*/
#include <stdio.h>
#include <stdlib.h>
int compare(const void *a, const void *b)
{
  return (*(int *)a - *(int *)b);
}
int main()
{
  int a[] = {5, 3, 5, 2, 5, 5, 5, 6, 5, 2};
  qsort(a, 10, sizeof(int), compare);
  for (int i = 0; i < 5; i++)
  {
    if (a[i] == a[i + 5])
    {
      printf("%d\n", a[i]);
      break;
    }
    else if (i == 5)
    {
      printf("None!");
    }
  }
  system("pause");
  return 0;
}
