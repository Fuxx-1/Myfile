#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int a;    //4
    double b; //8
    char C;   //1
    short d;  //2
} A;
typedef struct
{
    char C;   //1
    short d;  //2
    int a;    //4
    double b; //8
} B;
int main(void)
{
    printf("A�Ĵ�СΪ��%d\n", sizeof(A));
    printf("B�Ĵ�СΪ��%d\n", sizeof(B));

    system("pause");
    return 0;
}