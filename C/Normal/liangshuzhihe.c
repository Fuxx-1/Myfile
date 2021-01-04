/* 
给定一个整数数组 nums?和一个目标值 target，请你在该数组中找出
和为目标值的那?两个整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
*/
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int a[4] = {2, 7, 11, 15};
    int target = 9;
    int i, j;
    i = j = 0;
    for(; i < 3; i++)
    {
        for(; j < 3; j++)
        {
            if(a[i] + a[j] == target)
                break;
        }
        j = 0;
    }    
    printf("%d %d", i+1, j+1);

    system("pause");
    return 0;
}