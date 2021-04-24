#include <stdio.h>
#include <string.h>
#include <stdlib.h>
typedef struct List
{
    int id;
    char name[10];
    int age;
    struct List *next;
} Node;

Node *CreateList();                                               //创建List的Head节点
Node *CreateNode(char name[], int age, int id);                   //以传入的数据创建节点
Node *AddNodebyTail(Node *HeadNode, char name[], int age, int id); //头插法增加节点
void DeleteNodeByAge(Node *HeadNode, int PosDate);                //删除节点
void PrintList(Node *HeadNode);                                   //输出链表

int main(int argc, char const *argv[])
{
    Node *Head = CreateList();
    Node *Tail = Head;
    Tail = AddNodebyTail(Tail, "学生1", 12, 1);
    Tail = AddNodebyTail(Tail, "学生2", 14, 2);
    Tail = AddNodebyTail(Tail, "学生3", 20, 3);
    PrintList(Head);
    printf("---------------删除操作-------------\n");
    DeleteNodeByAge(Head, 12);
    sleep(1);
    printf("---------------删除后---------------\n");
    PrintList(Head);
    return 0;
}

Node *CreateList()
{
    Node *HeadNode = (Node *)malloc(sizeof(Node));
    HeadNode->next = NULL;
    return HeadNode;
}

Node *CreateNode(char name[], int age, int id)
{
    Node *NewNode = (Node *)malloc(sizeof(Node));
    strcpy(NewNode->name, name);
    // NewNode->name = name;
    NewNode->age = age;
    NewNode->id = id;
    NewNode->next = NULL;
    return NewNode;
}

Node *AddNodebyTail(Node *endNode, char name[], int age, int id)
{
    Node *NewNode = CreateNode(name, age, id);
    Node *EndNode = endNode;
    // while (EndNode->next)
    // {
    //     EndNode = EndNode->next;
    // }
    EndNode->next = NewNode;
    return NewNode;
}

void DeleteNodeByAge(Node *HeadNode, int PosDate)
{
    Node *PosNode = HeadNode->next;
    Node *PosNodeFront = HeadNode;
    if (!PosNode)
    {
        printf("无法删除链表，链表为空！\n");
    }
    else
    {
        while (PosNode->age - PosDate)
        {
            PosNodeFront = PosNode;
            PosNode = PosNodeFront->next;
            if (!PosNode)
            {
                printf("无相关信息！\n");
                return;
            }
        }
        PosNodeFront->next = PosNode->next;
        free(PosNode);
        printf("删除成功！\n");
    }
}

void PrintList(Node *HeadNode)
{
    Node *pMove = HeadNode->next;
    printf("%5s\t%10s\t%3s\n", "学生编号", "学生姓名", "年龄");
    while (pMove)
    {
        printf("%5d\t%15s\t%10d\n", pMove->id, pMove->name, pMove->age);
        pMove = pMove->next;
    }
}
