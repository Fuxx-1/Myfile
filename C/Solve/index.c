#include <stdio.h>
int main(void)
{
    system("chcp 65001");
    system("call cls");
    system("@echo off");
    printf("Designed For Fuxx-1【@GitHub】\n");
    printf("软件版本：v1.0.0\n作者：Fuxx-1【@GitHub】，博客链接：fuxx-1.github.io\n声明：本软件仅供学习参考，不做任何商业用途！\n");
    printf("*****按任意键生成网页*****\n");
    system("pause > nul");
    printf("*****网页开始生成······*****\n");
    system("del %~dp0index.html");
    system("echo ^<^!DOCTYPE html^> > %~dp0temp.txt");
    system("echo     ^<html lang=\"en\"^> >> %~dp0temp.txt");
    system("echo     ^<head^> >> %~dp0temp.txt");
    system("echo         ^<style^> >> %~dp0temp.txt");
    system("echo             .main { >> %~dp0temp.txt");
    system("echo                 width: 65^vw; >> %~dp0temp.txt");
    system("echo                 height: 100^vh; >> %~dp0temp.txt");
    system("echo                 margin: auto; >> %~dp0temp.txt");
    system("echo                 background-color: rgba(255, 255, 255, 0.7); >> %~dp0temp.txt");
    system("echo                 backdrop-filter: blur(7.5px); >> %~dp0temp.txt");
    system("echo                 border-radius: 10px 10px 10px 10px; >> %~dp0temp.txt");
    system("echo             } >> %~dp0temp.txt");
    system("echo             .link { >> %~dp0temp.txt");
    system("echo                 width: 50^vw; >> %~dp0temp.txt");
    system("echo                 margin: auto; >> %~dp0temp.txt");
    system("echo                 background-color: rgba(255, 255, 255, 0); >> %~dp0temp.txt");
    system("echo             } >> %~dp0temp.txt");
    system("echo             body { >> %~dp0temp.txt");
    system("echo                 background-image: url(https://fuxx-1.gitee.io/images/background.png); >> %~dp0temp.txt");
    system("echo                 background-size: 100^vw 100^vh; >> %~dp0temp.txt");
    system("echo                 background-attachment: fixed; >> %~dp0temp.txt");
    system("echo             } >> %~dp0temp.txt");
    system("echo         ^</style^> >> %~dp0temp.txt");
    system("echo         ^<meta charset=\"UTF-8\"^> >> %~dp0temp.txt");
    system("echo         ^<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"^> >> %~dp0temp.txt");
    system("echo         ^<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"^> >> %~dp0temp.txt");
    system("echo         ^<title^>我的网页^</title^> >> %~dp0temp.txt");
    system("echo     ^</head^> >> %~dp0temp.txt");
    system("echo     ^<body^> >> %~dp0temp.txt");
    system("echo         ^<div class=\"main\"^> >> %~dp0temp.txt");
    system("echo             ^<div class=\"link\"^> >> %~dp0temp.txt");
    system("echo                 ^<br^> >> %~dp0temp.txt");
    system("echo                 ^<h1^ align=\"center\"^>我的网页^</h1^> >> %~dp0temp.txt");
    system("echo                 ^<br^> >> %~dp0temp.txt");

    system("for /r . %%g in (*.html) do (echo ^<a href=\"%%g\" target=\"_blank\"^>%%~nxg^</a^>^<br^>^<br^> >> %~dp0temp.txt)");

    system("echo             ^</div^> >> %~dp0temp.txt");
    system("echo         ^</div^> >> %~dp0temp.txt");
    system("echo     ^</body^> >> %~dp0temp.txt");
    system("echo     ^</html^> >> %~dp0temp.txt");

    system("SetLocal EnableDelayedExpansion");
    system("Set File=%~dp0temp.txt");
    system("Set Str=%~dp0");
    system("Set Replace=http://fuxx-1.github.io/Course/");
    system("Set File=%File:\"=%");
    system("For /F \"Usebackq Delims=\" %%i In (\"%File%\") Do ( Set \"Line=%%i\"Echo !Line:%Str%=%Replace%! >> index.html\")");
    // system("del %~dp0temp.txt");
    printf("*****网页生成结束，按任意键退出*****\n");
    system("pause > nul");

    return 0;
}


@echo off
chcp 65001
cls

del %~dp0index.html

echo ^<^!DOCTYPE html^> > %~dp0temp.txt
echo     ^<html lang="en"^> >> %~dp0temp.txt
echo     ^<head^> >> %~dp0temp.txt
echo         ^<style^> >> %~dp0temp.txt
echo             .main { >> %~dp0temp.txt
echo                 width: 65^vw; >> %~dp0temp.txt
echo                 height: 110^vh; >> %~dp0temp.txt
echo                 margin: auto; >> %~dp0temp.txt
echo                 background-color: rgba(255, 255, 255, 0.7); >> %~dp0temp.txt
echo                 backdrop-filter: blur(7.5px); >> %~dp0temp.txt
echo                 border-radius: 10px 10px 10px 10px; >> %~dp0temp.txt
echo             } >> %~dp0temp.txt
echo             .link { >> %~dp0temp.txt
echo                 width: 50^vw; >> %~dp0temp.txt
echo                 margin: auto; >> %~dp0temp.txt
echo                 background-color: rgba(255, 255, 255, 0);
echo             } >> %~dp0temp.txt
echo             body { >> %~dp0temp.txt
echo                 background-image: url(https://fuxx-1.gitee.io/images/background.png); >> %~dp0temp.txt
echo                 background-size: 100^vw 100^vh; >> %~dp0temp.txt
echo                 background-attachment: fixed; >> %~dp0temp.txt
echo             } >> %~dp0temp.txt
echo         ^</style^> >> %~dp0temp.txt
echo         ^<meta charset="UTF-8"^> >> %~dp0temp.txt
echo         ^<meta http-equiv="X-UA-Compatible" content="IE=edge"^> >> %~dp0temp.txt
echo         ^<meta name="viewport" content="width=device-width, initial-scale=1.0"^> >> %~dp0temp.txt
echo         ^<title^>我的网页^</title^> >> %~dp0temp.txt
echo     ^</head^> >> %~dp0temp.txt
echo     ^<body^> >> %~dp0temp.txt
echo         ^<div class="main"^> >> %~dp0temp.txt
echo             ^<div class="link"^> >> %~dp0temp.txt
echo                 ^<br^> >> %~dp0temp.txt
echo                 ^<h1^ align="center"^>我的网页^</h1^> >> %~dp0temp.txt
echo                 ^<br^> >> %~dp0temp.txt

for /r . %%g in (*.html) do (echo ^<a href="%%g" target="_blank"^>%%~nxg^</a^>^<br^>^<br^> >> %~dp0temp.txt)

echo             ^</div^> >> %~dp0temp.txt
echo         ^</div^> >> %~dp0temp.txt
echo     ^</body^> >> %~dp0temp.txt
echo     ^</html^> >> %~dp0temp.txt


SetLocal EnableDelayedExpansion
Set File=%~dp0temp.txt
Set Str=%~dp0
Set Replace=http://fuxx-1.github.io/Hidden/
Set File=%File:"=%
For /F "Usebackq Delims=" %%i In ("%File%") Do (
    Set "Line=%%i"
    Echo !Line:%Str%=%Replace%! >> index.html
)
del %~dp0temp.txt
echo 完成
pause