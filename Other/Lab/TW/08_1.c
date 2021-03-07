#include <stdio.h>
#include <stdlib.h>
int count(int val)
{
    if(!(val-1))
        return 1;
    else if(!(val-2))
        return 2;
    else
        return count(val - 1) + count(val - 2);
}
int main(void)
{
    int val = 0;
    scanf("%d", &val);
    printf("%d\n", count(val));
    system("pause");
    return 0;
}