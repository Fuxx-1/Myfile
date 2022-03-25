/* 头文件区 */

#include <String.h>
#include <Windows.h>
#include <stdio.h>
#include <stdlib.h>

/* 函数定义区 */

int ShowIn(); // 利用dos命令显示根目录下的*.in文件
int FileIn(char filename[]); //文件输入
int NewMaze(char filename[]); //新建迷宫
int StdOut(int length); // 输出解
int FileOut(char filename[], int length); //解输出至文件
int GetQueue(); //出队
int SetQueue(int a, int b); //入队
int isEmptyQueue(); //判空
int Solute(); //解迷宫
int CanTrample(int a, int b); //迷宫该点是否能走
void pause(); //暂停函数
void MainMenu(); //主菜单
void clear(); //清空

/* 变量定义区 */

int Maze[101][101]; //储存迷宫
int Config[2]; //存行列，[0]为列，[1]为行
int Queue[150][2]; //队列
int Que_temp[2]; //队列缓存

/* 主函数区 */

int main(int argc, char const* argv[])
{
    system("chcp 65001 > nul"); //编码格式
    char filename[20]; //文件名
    filename[0] = '.';
    filename[1] = '\\'; //当前路径
    int choice1 = 0; //选择
    do {
        clear();
        MainMenu();
        scanf("%d", &choice1);
        clear();
        if (choice1 == 1) {
            ShowIn();
            printf("请输入要打开的文件全名：\n");
            scanf("%s", &filename[2]);
            FileIn(filename);
            
            int length = Solute();
            if (length) {
                StdOut(length);
                FileOut(filename, length);
            } else {
                printf("无解...\n");
            }
            /*以下代码用于直接搜索展示out文件
            char name[30];
            int length = strlen(filename);
            filename[++length] = 0;
            filename[--length] = 't';
            filename[--length] = 'u';
            filename[--length] = 'o';
            strcpy(name, "type ");
            strcat(name, filename);
            system(name);
            pause(); */
        } else if (choice1 == 2) {
            printf("请输入要创建的迷宫文件全名：\n");
            scanf("%s", &filename[2]);
            NewMaze(filename);
            int length = Solute();
            if (length) {
                StdOut(length);
                FileOut(filename, length);
            } else {
                printf("无解...\n");
            }
        } else {
            break;
        }
    } while (choice1);
    return 0;
}

/* 函数实现区 */

void MainMenu()
{
    printf("\n\n\n\n");
    printf("\t\t\t+---------------------------+\n");
    printf("\t\t\t|                           |\n");
    printf("\t\t\t|      迷宫问题解决程序     |\n");
    printf("\t\t\t|                           |\n");
    printf("\t\t\t|     0: 退出程序           |\n");
    printf("\t\t\t|     1: 打开现有迷宫文件   |\n");
    printf("\t\t\t|     2: 创建新迷宫文件     |\n");
    printf("\t\t\t|                           |\n");
    printf("\t\t\t+---------------------------+\n");
    printf("\t\t\t请输入你的选项：");
}

void clear()
{
    system("cls");
}

int Solute()
{
    // 遍历获得出入口并储存
    int In[2];
    int Out[2];
    for (int i = 0; i < Config[0]; i++) {
        for (int j = 0; j < Config[1]; j++) {
            Maze[i][j] = -Maze[i][j];
            if (Maze[i][j] == -2) {
                In[0] = i;
                In[1] = j;
            }
            if (Maze[i][j] == -3) {
                Out[0] = i;
                Out[1] = j;
            }
        }
    }
    // 起点入队并改为1
    SetQueue(In[0], In[1]);
    Maze[In[0]][In[1]] = 1;
    // 运算路径
    int temp, flag = 0;
    while (!isEmptyQueue()) {
        //出队
        temp = GetQueue();
        //方向1
        if (Maze[Queue[temp][0] + 1][Queue[temp][1]] == -3) {
            //到达终点
            temp = Maze[Queue[temp][0]][Queue[temp][1]]; //储存步数
            flag = 1; //表示有解
            break;
        } else {
            if (CanTrample(Queue[temp][0] + 1, Queue[temp][1])) {
                Maze[Queue[temp][0] + 1][Queue[temp][1]] = Maze[Queue[temp][0]][Queue[temp][1]] + 1;
                //路径加一
                SetQueue(Queue[temp][0] + 1, Queue[temp][1]);
                //入队
            }
        }
        //方向2
        if (Maze[Queue[temp][0]][Queue[temp][1] + 1] == -3) {
            temp = Maze[Queue[temp][0]][Queue[temp][1]];
            flag = 1;
            break;
        } else {
            if (CanTrample(Queue[temp][0], Queue[temp][1] + 1)) {
                Maze[Queue[temp][0]][Queue[temp][1] + 1] = Maze[Queue[temp][0]][Queue[temp][1]] + 1;
                SetQueue(Queue[temp][0], Queue[temp][1] + 1);
            }
        }
        //方向3
        if (Maze[Queue[temp][0] - 1][Queue[temp][1]] == -3) {
            temp = Maze[Queue[temp][0]][Queue[temp][1]];
            flag = 1;
            break;
        } else {
            if (CanTrample(Queue[temp][0] - 1, Queue[temp][1])) {
                Maze[Queue[temp][0] - 1][Queue[temp][1]] = Maze[Queue[temp][0]][Queue[temp][1]] + 1;
                SetQueue(Queue[temp][0] - 1, Queue[temp][1]);
            }
        }
        //方向4
        if (Maze[Queue[temp][0]][Queue[temp][1] - 1] == -3) {
            temp = Maze[Queue[temp][0]][Queue[temp][1]];
            flag = 1;
            break;
        } else {
            if (CanTrample(Queue[temp][0], Queue[temp][1] - 1)) {
                Maze[Queue[temp][0]][Queue[temp][1] - 1] = Maze[Queue[temp][0]][Queue[temp][1]] + 1;
                SetQueue(Queue[temp][0], Queue[temp][1] - 1);
            }
        }
    }
    Que_temp[0] = 0;
    Que_temp[1] = 0;
    int length = temp; //储存长度
    //正向广搜完成，开始追朔路径并标记
    if (flag) {
        //有解
        while (--temp) {
            if (Maze[Out[0] + 1][Out[1]] == temp + 1) {
                //方向1
                Maze[Out[0] + 1][Out[1]] = -4;
                Out[0]++;
            } else if (Maze[Out[0] - 1][Out[1]] == temp + 1) {
                //方向2
                Maze[Out[0] - 1][Out[1]] = -4;
                Out[0]--;
            } else if (Maze[Out[0]][Out[1] - 1] == temp + 1) {
                //方向3
                Maze[Out[0]][Out[1] - 1] = -4;
                Out[1]--;
            } else if (Maze[Out[0]][Out[1] - 1] == temp + 1) {
                //方向4
                Maze[Out[0]][Out[1] - 1] = -4;
                Out[1]--;
            } else {
                return 0;
            }
        }
        //遍历并消除多余值
        for (int i = 0; i < Config[0]; i++) {
            for (int j = 0; j < Config[1]; j++) {
                if (Maze[i][j] == 1) {
                    Maze[i][j] = -2;
                    //起点恢复
                }
                if (Maze[i][j] > 1) {
                    Maze[i][j] = 0;
                }
            }
        }
        return length;
    } else {
        //无解
        return 0;
    }
}

int ShowIn()
{
    printf("+---------------------------+\n");
    printf("  以下为所有存在的迷宫文件：  \n");
    //dos命令
    system("DIR *.in  /B");
    printf("+---------------------------+\n");
    return 1;
}

int FileIn(char filename[])
{
    //清屏
    clear();
    //打开文件
    FILE* fp = NULL;
    fp = fopen(filename, "r");
    if (!fp) {
        return 0;
    }
    //输入
    fscanf(fp, "%d %d", &Config[0], &Config[1]);
    for (int i = 0; i < Config[0]; i++) {
        for (int j = 0; j < Config[1]; j++) {
            fscanf(fp, "%d", &Maze[i][j]);
        }
    }
    fclose(fp);
    //展示
    printf("文件内迷宫[%s]:\n\n", &filename[2]);
    for (int i = 0; i < Config[0]; i++) {
        for (int j = 0; j < Config[1]; j++) {
            printf("%d ", Maze[i][j]);
        }
        printf("\n");
    }
    printf("\n");
    pause();
    //返回
    return 1;
}

int NewMaze(char filename[])
{
    //打开文件
    FILE* fp = NULL;
    fp = fopen(filename, "w");
    //用户输入
    printf("\t\t+-----------------------------+\n");
    printf("\t\t|                             |\n");
    printf("\t\t|          输入样例：         |\n");
    printf("\t\t|                             |\n");
    printf("\t\t|          2 3                |\n");
    printf("\t\t|          2 0 0              |\n");
    printf("\t\t|          0 1 3              |\n");
    printf("\t\t|                             |\n");
    printf("\t\t+-----------------------------+\n");
    printf("请输入迷宫行列（先列后行）：\n");
    scanf("%d %d", &Config[0], &Config[1]);
    printf("请输入迷宫（路为0，墙为1，入口为2，出口为3）：\n");
    for (int i = 0; i < Config[0]; i++) {
        for (int j = 0; j < Config[1]; j++) {
            scanf("%d", &Maze[i][j]);
        }
    }
    //写文件
    printf("===文件写入===\n");
    printf("文件写入中...\r");
    fprintf(fp, "%d %d\n", Config[0], Config[1]);
    for (int i = 0; i < Config[0]; i++) {
        for (int j = 0; j < Config[1]; j++) {
            fprintf(fp, "%d ", Maze[i][j]);
        }
        fprintf(fp, "\n");
    }
    fclose(fp);
    printf("文件写入完成...\n");
    pause();
    // system("cls");
    return 1;
}

int StdOut(int length)
{
    printf("===结果：===\n");
    printf("最短路径：%d\n", length);
    for (int i = 0; i < Config[0]; i++) {
        for (int j = 0; j < Config[1]; j++) {
            if (Maze[i][j] == -1) {
                printf("F ");
            } else if (Maze[i][j] == -2) {
                printf("I ");
            } else if (Maze[i][j] == -3) {
                printf("O ");
            } else if (Maze[i][j] == -4) {
                printf("W ");
            } else {
                printf("S ");
            }
        }
        printf("\n");
    }
    printf("S:空 F:墙 I:入口 O:出口 W:路 \n");
    printf("\n");
    pause();
    return 1;
}

int GetQueue()
{
    return isEmptyQueue() ? -1 : Que_temp[0]++;
}

int SetQueue(int a, int b)
{
    if ((Que_temp[1] + 1) % 150 != Que_temp[0] % 150) {
        Queue[(Que_temp[1]) % 150][0] = a;
        Queue[(Que_temp[1]) % 150][1] = b;
    }
    Que_temp[1]++;
    return 1;
}

int isEmptyQueue()
{
    return Que_temp[0] == Que_temp[1];
}

int CanTrample(int a, int b)
{
    if (a >= 0 && b >= 0 && a < Config[0] && b < Config[1] && !Maze[a][b]) {
        return 1;
    }
    return 0;
}

int FileOut(char filename[], int length)
{
    printf("\n===文件写入===\n");
    printf("文件写入中...\r");
    //打开文件
    FILE* fp = NULL;
    int File_length = strlen(filename);
    filename[++File_length] = 0;
    filename[--File_length] = 't';
    filename[--File_length] = 'u';
    filename[--File_length] = 'o';
    fp = fopen(filename, "w");
    //写文件
    fprintf(fp, "===结果：===\n");
    fprintf(fp, "最短路径：%d\n", length);
    for (int i = 0; i < Config[0]; i++) {
        for (int j = 0; j < Config[1]; j++) {
            if (Maze[i][j] == -1) {
                fprintf(fp, "F ");
            } else if (Maze[i][j] == -2) {
                fprintf(fp, "I ");
            } else if (Maze[i][j] == -3) {
                fprintf(fp, "O ");
            } else if (Maze[i][j] == -4) {
                fprintf(fp, "W ");
            } else {
                fprintf(fp, "S ");
            }
        }
        fprintf(fp, "\n");
    }
    fprintf(fp, "S:空 F:墙 I:入口 O:出口 W:路 \n");
    fprintf(fp, "\n");
    fclose(fp);
    printf("文件写入完成...\n");
    pause();
    return 1;
}

void pause()
{
    printf("===按任意键继续===\r");
    system("pause > nul");
    printf("                       \r");
}