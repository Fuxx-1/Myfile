#include <stdio.h>
int main(void)
{
    system("chcp 65001");
    system("call cls");
    system("@echo off");
    printf("软件版本：v1.0.0\n作者：Fuxx-1【@GitHub】，博客链接：fuxx-1.github.io\n声明：本软件仅供学习参考，不做任何商业用途！\n");
    printf("*****按任意键开始同步*****\n");
    system("pause > nul");
    system("cd  %~dp0");
    system("call git add --all");
    system("call git commit -m \"%date:~3,4%-%date:~8,2%-%date:~11,2%\"");
    printf("*****更改已提交，等待推送*****\n");
    int a = 100;
    while (a < 300)
    {
        a = scanf(system("call git push origin main"));
    }
    printf("*****命令执行结束，按任意键退出*****\n");
    system("pause > nul");
    return 0;
}