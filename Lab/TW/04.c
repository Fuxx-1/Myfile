#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    int a;
    double b;
    char C;
    short d;
} A;
typedef struct
{
    char C;
    short d;
    int a;
    double b;
} B;
int main(void)
{
    printf("A�Ĵ�СΪ��%d\n", sizeof(A));
    printf("B�Ĵ�СΪ��%d\n", sizeof(B));
    
    system("pause");
    return 0;
}