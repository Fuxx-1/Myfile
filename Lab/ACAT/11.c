/* 
11. 
//32位系统
请问x1,x2,x3输出是什么，为什么？
 */
#include <stdio.h>
#include <stdlib.h>
struct
{
    int i;   //4
    char c1; //1
    char c2; //1
} x1;
struct
{
    char c1; //1
    int i;   //4
    char c2; //1
} x2;
struct
{
    char c1; //1
    char c2; //1
    int i;   //2
} x3;

int main()
{
    printf("x1=%d\n", sizeof(x1));
    printf("x2=%d\n", sizeof(x2));
    printf("x3=%d\n", sizeof(x3));

    system("pause");
    return 0;
}