#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int i = 0;
    printf("���������֣�\n");
    scanf("%d", &i);
    if((i&1) == 0)
        printf("����\n");
    else
        printf("ż��\n");
    
    system("pause");
    return 0;
}