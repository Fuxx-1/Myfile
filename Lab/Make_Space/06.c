/*
6． 以下程序中，while循环的循环次数是（） 
        int i=0;
        while(i<10)
{
             if(i<1) continue;
              if(i==5) break;
              i++; 
         }
A．1 B．10   C．6 D．死循环，不能确定次数
*/
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int i = 0;
    int times = 0; //统计次数
    while (i < 10)
    {
        ++times;               //统计次数
        printf("%d\n", times); //统计次数
        if (i < 1)
            continue;
        if (i == 5)
            break;
        i++;
    }
    system("pause");
    return 0;
}