/* 
本树以 Age 作为查找依据
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct TreeofStudent {
    int id;
    char name[10];
    int age;
    struct TreeofStudent* Pre;
    struct TreeofStudent* Next;
} Node;

Node* CreateNode(int id, char name[], int age);
void AddNode(Node* BodyNode, int id, char name[], int age);
void InsertNode(Node* BodyNode, Node* NewNode);
void PrintTreeFront(Node* Body);
void PrintTreeAfter(Node* Body);
void PrintTreeIn(Node* Body);
void PrintTitle();

int main(int argc, char const* argv[])
{
    Node* BodyNode = CreateNode(1, "学生1", 30);
    AddNode(BodyNode, 2, "学生2", 20);
    AddNode(BodyNode, 3, "学生3", 40);
    AddNode(BodyNode, 4, "学生4", 10);
    AddNode(BodyNode, 5, "学生5", 25);
    AddNode(BodyNode, 6, "学生6", 35);
    AddNode(BodyNode, 7, "学生7", 45);
    PrintTitle();
    PrintTreeFront(BodyNode);
    DeleteNode(BodyNode, 25);
    PrintTitle();
    PrintTreeFront(BodyNode);
    return 0;
}

Node* CreateNode(int id, char name[], int age)
{
    Node* NewNode = (Node*)malloc(sizeof(Node));
    NewNode->id = id;
    strcpy(NewNode->name, name);
    NewNode->age = age;
    NewNode->Pre = NULL;
    NewNode->Next = NULL;
    return NewNode;
}

void AddNode(Node* BodyNode, int id, char name[], int age)
{
    Node* NewNode = CreateNode(id, name, age);
    InsertNode(BodyNode, NewNode);
}

void InsertNode(Node* BodyNode, Node* NewNode)
{
    if (NewNode->age < BodyNode->age) {
        if (BodyNode->Pre) {
            InsertNode(BodyNode->Pre, NewNode);
        } else {
            BodyNode->Pre = NewNode;
        }
    }
    if (NewNode->age > BodyNode->age) {
        if (BodyNode->Next) {
            InsertNode(BodyNode->Next, NewNode);
        } else {
            BodyNode->Next = NewNode;
        }
    }
}

void PrintTreeFront(Node* Body)
{
    if (Body) {
        printf("%5d\t%15s\t%10d\n", Body->id, Body->name, Body->age);
        PrintTreeFront(Body->Pre);
        PrintTreeFront(Body->Next);
    }
}
void PrintTreeAfter(Node* Body)
{
    if (Body) {
        PrintTreeAfter(Body->Pre);
        PrintTreeAfter(Body->Next);
        printf("%5d\t%15s\t%10d\n", Body->id, Body->name, Body->age);
    }
}
void PrintTreeIn(Node* Body)
{
    if (Body) {
        PrintTreeIn(Body->Pre);
        printf("%5d\t%15s\t%10d\n", Body->id, Body->name, Body->age);
        PrintTreeIn(Body->Next);
    }
}
void PrintTitle()
{
    printf("%5s\t%10s\t%3s\n", "学生编号", "学生姓名", "年龄");
}