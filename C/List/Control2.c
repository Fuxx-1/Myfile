#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <windows.h>
enum
{ //操作
    UP = 72,
    DOWN = 80,
    LEFT = 75,
    RIGHT = 77,
    ENTER = 13,
    ESC = 27,
};
char *menu[] = {
    //功能
    "** 功能A **",
    "** 功能B **",
    "** 功能C **",
    "** 功能D **",
    "** 功能E **",
    "** 退出  **",
};
//定义默认的坐标位置
COORD pos = {0, 0};
//显示菜单
void showmenu(HANDLE hOut, char **menu, int size, int index);
//获取用户输入
int get_userinput(int *index, int size);
int main(void)
{
    system("chcp 65001");
    int i;
    int ret;
    int index = 0;
    HANDLE hOut;
    hOut = GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleTitleA("学生信息管理系统");
    while (1)
    {
        showmenu()
    }
    system("pause");
    return 0;
}
