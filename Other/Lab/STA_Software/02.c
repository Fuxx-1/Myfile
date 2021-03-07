#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int i = 0;
    printf("请输入数字：\n");
    scanf("%d", &i);
    if((i&1) == 0)
        printf("奇数\n");
    else
        printf("偶数\n");
    
    system("pause");
    return 0;
}