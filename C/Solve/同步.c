#include <stdio.h>
int main(void)
{
    system("chcp 65001");
    system("call cls");
    system("@echo off");
    printf("*****按任意键开始同步*****\n");
    system("pause > nul");
    system("cd  %~dp0");
    system("call git add --all");
    system("call git commit -m \"%date:~3,4%-%date:~8,2%-%date:~11,2%\"");
    printf("*****更改已提交，等待推送······*****\n\n");
    system("call git push origin main");
    printf("*****命令执行结束，按任意键开始退出*****\n");
    system("pause > nul");
    return 0;
}
