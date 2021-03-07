chcp 65001
call cls
@echo off
echo -----按任意键开始-----
pause
cd  %~dp0
call git add --all
call git commit -m "%date:~3,4%-%date:~8,2%-%date:~11,2%"
call git push origin main
echo -----命令执行结束-----
pause