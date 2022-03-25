#include <stdio.h>
#include <stdlib.h>
#define M 10
int main(int argc, char const *argv[])
{
    /* code */
    int num[M];
    int i = 0, j = 0;
    for(i = 0;i < M;i++){
        scanf("%d",&num[i]);
    }
    //假如这串数字已经排好序了
    i = 1 , j = 1; 
    while (i < M)
    {
        if(num[i] != num[i - 1]){
            num[j] = num[i];
            j++;
        }
        i++;
    }
    //打印目标数段
    for(i = 0; i < j;i++){
        printf("%d ",num[i]);
    }
    return 0;
}

