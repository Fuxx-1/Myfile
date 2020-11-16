/* 请解释一下这行代码做了什么？ */
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
    puts((char *)(int const[]){0X6F796958, 0X6E694C75, 0X72477875, 0X3270756F, 0X313230, 0X00000A});
    
    system("pause");
    return 0;
}
