#include <stdio.h>
#include <stdlib.h>
struct S
{
    union S1
    {
        int a;      //4
        double c;   //8
        char e[13]; //13    13
    } s;
    char a; //1
    int t;  //4
};

int main(void)
{
    char e[13];
    printf("%d\n", sizeof(struct S));
    printf("%d\n", sizeof(e));
    system("pause");
    return 0;
}