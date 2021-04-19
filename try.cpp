#include <stdio.h>
typedef struct Sutdent
{
    int num;
    int source;
    char name[20];
    struct Student *next;
} STU;

int main(int argc, char const *argv[])
{
    printf("%d", sizeof(STU->num));
    return 0;
}
