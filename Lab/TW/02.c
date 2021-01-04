#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a = 5, b = 7;
    a = a^b;
    b = b^a;
    a = a^b;
    printf("a为：%d\nb为：%d\n", a, b);
/* a为：7
b为：5 */
    system("pause");
    return 0;
}