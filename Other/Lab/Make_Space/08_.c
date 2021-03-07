/*
8、写出打印结果  
 int main()
 {
    char a[1000];
    int i;
    for(i=0;i<1000;i++)
    {
      a[i]=-1-i;  
    }
printf("%d",strlen(a));
    return 0;
}
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(void)
{
    char a[1000];
    int i;
    for (i = 0; i < 1000; i++)
    {
        a[i] = -1 - i;
    }
    printf("%d\n", strlen(a));
    

    system("pause");
    return 0;
}
/*
1. strlen所作的是一个计数器的工作，它从内存的某个位置开始扫描，
    直到碰到第一个字符串结束符'\0'为止，然后返回计数器值。
2. char储存的范围是255个数。
*/