#include <stdio.h>
#include <stdlib.h>
typedef union //20  max{8, 20, 1}
{
    long i;   //8
    int k[5]; //20
    char C;   //1
} DATE;
DATE max;

struct data //32
{
    int cat;    //4
    DATE cow;   //20
    double dog; //8
};

int main(void)
{
    printf("%d\n", sizeof(struct data) + sizeof(max)); //52=32 + 20
    printf("%d\n", sizeof(struct data));               //32
    printf("%d\n", sizeof(max));                       //20
    printf("%d\n", sizeof(max.k));                     //20

    system("pause");
    return 0;
}