#include <stdio.h>
#include <stdlib.h>

int Compute(int Value)
{
    if(Value == 1)
        return 3;
    else if(Value == 2)
        return 3;
    else if(Value <= 0)
        return 0;
    else
        return Compute(Value - 1) + Compute(Value - 2);
}
int main(void)
{
    int a = 0;
    scanf("%d", &a);
    printf("%d\n", Compute(a));
    
    system("pause");
    return 0;
}