#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int Val;
    scanf("%d", &Val);
    int i = 0;
    int a_1 = 3;
    int a_2 = 3;
    for (int a = 2; (a - Val); a++)
    {
        if (!(Val - 1) || !(Val - 2))
            i = 3;
        else
        {
            i = a_1 + a_2;
            a_1 = a_2;
            a_2 = i;
        }
    printf("%d\n", i);
    }
    printf("µÚ%d¸öÖµ£º", Val);
    printf("%d\n", i);

    system("pause");
    return 0;
}