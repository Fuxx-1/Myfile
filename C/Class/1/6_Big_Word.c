/* 
输入可大写可小写
输出大写
 */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    char a;
    printf("请输入字母：\n");
    scanf("%c", &a);
    printf("输入的字母：\n%c\n", a);
    if (a > 65)
    {
        a = a + ('A' - 'a');
    }
    printf("输出的字母：\n%c\n", a);

    system("pause");
    return 0;
}