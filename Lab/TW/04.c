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
    printf("A的大小为：%d\n", sizeof(A));
    printf("B的大小为：%d\n", sizeof(B));
    
    system("pause");
    return 0;
}