#include <stdio.h>
#include <stdlib.h>
int count(int val)
{
    if(!(val-1)||!(val-2))
        return 3;
    else
        return count(val - 1) + count(val - 2);
}
int main(void)
{
    int val = 0;
    scanf("%d", &val);
    printf("%d", count(val));
    system("pause");
    return 0;
}