/*
7．若有以下定义和语句：
char c1='b',c2='e'; 
printf("%d,%c\n",c2-c1,c2-'a'+'A'); 
则输出结果是:（）
A. 2,M B. 3,E C. 2,E    D. 输出项与对应的格式控制不一致,输出结果不确定。
*/
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    char c1 = 'b', c2 = 'e';
    printf("%d,%c\n",c1-c2,c2-'a'+'A');
    
    system("pause");
    return 0;
}