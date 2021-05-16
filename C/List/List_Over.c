#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
typedef struct List {
    int id;
    char name[10];
    int age;
    struct List* next;
} Node;
int Os_flag = 0;
Node* CreateList(); //创建List的Head节点
Node* CreateNode(char name[], int age, int id); //以传入的数据创建节点
Node* AddNodebyTail(Node* endNode, char name[], int age, int id); //头插法增加节点
Node* AddByInfo(Node* HeadNode); //获取信息，带提示
Node* MenuFunction(int chose, Node* HeadNode, Node* endNode); //菜单功能
bool NodeEqual(Node* PosNode, int mode); //查询
void DeleteNodeByAge(Node* HeadNode, int PosDate); //删除节点
void PrintList(Node* HeadNode); //输出链表
void PrintMenu(); //打印菜单
void SearchOs(); //判别系统类型
void ClearScreen(); //清屏
//更改信息

int main(int argc, char const* argv[])
{
    SearchOs();
    if (Os_flag == 2) {
        system("chcp 65001");
    }
    int chose = 1;
    Node* Head = CreateList();
    Node* Tail = Head;
    while (1) {
        PrintMenu();
        scanf("%d", &chose);
        if (chose == 0) {
            break;
        } else if (chose <= 5 && chose >= 0) {
            ClearScreen();
            getchar();
            Tail = MenuFunction(chose, Head, Tail);
        } else {
            printf("确定没输错???");
        }
    }
    return 0;
}

Node* AddByInfo(Node* endNode)
{
    int id;
    char name[10];
    int age;
    //获得信息
    puts("请输入id(纯数字, 回车结束)：");
    scanf("%d", &id);
    puts("请输入Name(回车结束)：");
    scanf("%s", &name);
    puts("请输入年龄(纯数字, 回车结束)：");
    scanf("%d", &age);
    //放入链表
    return AddNodebyTail(endNode, name, age, id);
}

Node* CreateList()
{
    Node* HeadNode = (Node*)malloc(sizeof(Node));
    HeadNode->next = NULL;
    return HeadNode;
}

Node* CreateNode(char name[], int age, int id)
{
    Node* NewNode = (Node*)malloc(sizeof(Node));
    strcpy(NewNode->name, name);
    NewNode->age = age;
    NewNode->id = id;
    NewNode->next = NULL;
    return NewNode;
}

Node* AddNodebyTail(Node* endNode, char name[], int age, int id)
{
    Node* NewNode = CreateNode(name, age, id);
    Node* EndNode = endNode;
    EndNode->next = NewNode;
    return NewNode;
}

void DeleteNodeByAge(Node* HeadNode, int PosDate)
{
    Node* PosNode = HeadNode->next;
    Node* PosNodeFront = HeadNode;
    if (!PosNode) {
        printf("无法删除链表，链表为空！\n");
    } else {
        while (PosNode->age - PosDate) {
            PosNodeFront = PosNode;
            PosNode = PosNodeFront->next;
            if (!PosNode) {
                printf("无相关信息！\n");
                return;
            }
        }
        PosNodeFront->next = PosNode->next;
        free(PosNode);
        printf("删除成功！\n");
    }
}

void PrintList(Node* HeadNode)
{
    Node* pMove = HeadNode->next;
    printf("%5s\t%10s\t%3s\n", "学生编号", "学生姓名", "年龄");
    while (pMove) {
        printf("%5d\t%15s\t%10d\n", pMove->id, pMove->name, pMove->age);
        pMove = pMove->next;
    }
}

bool NodeEqual(Node* PosNode, int mode)
{
}

void SearchOs()
{
#ifdef __linux__
    Os_flag = 1;
#endif
#ifdef __WINDOWS_
    Os_flag = 2;
#endif
#ifdef _WIN32
    Os_flag = 2;
#endif
}

void ClearScreen()
{
    if (Os_flag == 1) {
        system("clear");
    } else if (Os_flag == 2) {
        system("cls");
    }
}

void PrintMenu()
{
    ClearScreen();
    printf("\n\n\n\n\n");
    printf("\t\t (1)查询信息 \n");
    printf("\t\t (2)增加新信息 \n");
    printf("\t\t (3)删除信息 \n");
    printf("\t\t (4)更改信息 \n");
    printf("\t\t (5)列表查看全部信息 \n");
    printf("\t\t (0)退出 \n");
    printf("\n\n\n\n\n\t\t请输入数字：");
}

Node* MenuFunction(int chose, Node* HeadNode, Node* endNode)
{
    char temp[10];
    switch (chose) {
    case 1: //查询信息
        printf("您选择的功能_查询信息\n");
        return AddByInfo(HeadNode);
    case 2: //增加新信息
        printf("您选择的功能_增加新信息\n");
        return AddByInfo(HeadNode);
        break;
    case 3: //删除信息
        printf("您选择的功能_删除信息\n");
        return AddByInfo(HeadNode);
        break;
    case 4: //更改信息
        printf("您选择的功能_更改信息\n");
        return AddByInfo(HeadNode);
        break;
    case 5: //列表查看全部信息
        printf("您选择的功能_列表查看全部信息\n");
        PrintList(HeadNode);
        printf("---按回车退出---\n");
        getchar();
        return endNode;

    default:
        break;
    }
}