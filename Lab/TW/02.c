#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a = 5, b = 7;
    a = a^b;
    b = b^a;
    a = a^b;
    printf("aΪ��%d\nbΪ��%d\n", a, b);
/* aΪ��7
bΪ��5 */
    system("pause");
    return 0;
}