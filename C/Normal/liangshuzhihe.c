/* 
����һ���������� nums?��һ��Ŀ��ֵ target�������ڸ��������ҳ�
��ΪĿ��ֵ����?�������������������ǵ������±ꡣ
����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ�ز���ʹ�����顣
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