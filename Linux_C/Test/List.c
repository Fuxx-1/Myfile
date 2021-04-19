#include <stdio.h>
#include <stdlib.h>
typedef struct List
{
    char name[10];
    int age;
    struct List *next;
} Node;
Node CreateList()
{
    Node* HeadNode = (Node*)malloc(sizeof(Node));
    HeadNode->next = NULL;
    return HeadNode;
}
Node CreateNode(char name[], int age)
{
    Node* NewNode = (Node*)malloc(sizeof(Node));
    strcpy(NewNode->name, name);
    // NewNode->name = name;
    NewNode->age = age;
    NewNode->next = NULL;
    return NewNode;
}
void AddNodebyHead(Node* HeadNode, char name[], int age)
{
    Node* NewNode = CreateNode(name, age);
    NewNode->next = HeadNode->next;
    HeadNode->next = NewNode;
}
void AddNodebyTail(Node* HeadNode, char name[], int age)
{
    Node* NewNode = CreateNode(name, age);
    Node* PosNode = HeadNode->next;
    Node* PosNodeFront = HeadNode;
    while (!PosNode)
    {
        PosNodeFront = PosNode;
        PosNode = PosNodeFront->next;
    }
}
void DeleteNodeByAppoin(Node HeadNode, int PosDate)
{
    Node* PosNode = HeadNode->next;
    Node* PosNodeFront = HeadNode;
    if (!PosNode)
    {
        printf("无法删除链表，链表为空！\n");
    }
    else
    {
        while (!(PosNode->age - PosDate))
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
    }
}
void PrintList(Node HeadNode)
{
    Node* pMove = HeadNode->next;
    while (pMove)
    {
        printf("%10s\t%3d\n", pMove->name, pMove->age);
        pMove = pMove->next;
    }
}
int main(int argc, char const *argv[])
{
    Node* list = CreateList();
    AddNodebyHead(list, "akjdsfl", 1);
    AddNodebyHead(list, "sdlksdf", 2);
    AddNodebyHead(list, "jdlkads", 3);
    PrintList(list);
    DeleteNodeByAppoin(list, 2);
    printf("------------删除后-----------\n");
    PrintList(list);
    return 0;
}