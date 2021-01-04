/*
10.MakerSpace实验室里有两只懒狗，嘉嘉子学长每天都会安排一个懒狗打扫卫生。为了公平起见，
  嘉嘉子会说出10个数字（如{5,3,5,2,5,5,5,6,5,2}）,其中相同数字过半的数被称为优胜数，
  如果数组中没有优胜数，则输出”None!”，如果有，则输出它。最快输出结果的人可以不用打扫卫生，
  你找到最快的方法输出结果吗？
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
