#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Student {
    int id;
    char name[20];
    int age;
    struct Student* Pre;
    struct Student* next;
} Node;

void InsertNode(Node* PosNode, Node* MainNode);
void AddNode(int id, char name[], int age, Node* MainNode);
// void Del(char mode[], Node* MainNode);
void DelNode(int age, Node* MainNode);
void PrintTree(char mode, Node* MainNode);
void PrintTitle();
Node* CreatTree();
Node* CreatNode(int id, char name[], int age);

int main(int argc, char const* argv[])
{
    Node* MotherNode = CreatTree();
    AddNode(1, "1", 5, MotherNode);
    AddNode(2, "2", 4, MotherNode);
    AddNode(3, "3", 3, MotherNode);
    AddNode(4, "4", 2, MotherNode);
    AddNode(5, "5", 1, MotherNode);
    AddNode(6, "6", 6, MotherNode);
    AddNode(7, "7", 7, MotherNode);
    AddNode(8, "8", 8, MotherNode);
    AddNode(9, "9", 9, MotherNode);
    AddNode(10, "10", 10, MotherNode);
    PrintTitle();
    PrintTree('2', MotherNode);
    return 0;
}

void InsertNode(Node* PosNode, Node* MainNode)
{
    if (PosNode->age < MainNode->age) {
        if (!MainNode->Pre) {
            MainNode->Pre = PosNode;
        } else {
            InsertNode(PosNode, MainNode->Pre);
        }

    } else {
        if (!MainNode->next) {
            MainNode->next = PosNode;
        } else {
            InsertNode(PosNode, MainNode->next);
        }
    }
}

void AddNode(int id, char name[], int age, Node* MainNode)
{
    if (!MainNode->id) {
        MainNode->id = id;
        strcpy(MainNode->name, name);
        MainNode->age = age;
    } else {
        Node* NewNode = CreatNode(id, name, age);
        InsertNode(NewNode, MainNode);
    }
}

// void Del(char mode[], Node* MainNode);
// void DelNode(int age, Node* MainNode);

void PrintTree(char mode, Node* MainNode)
{
    if (MainNode) {
        if (!(mode-'1')) {
            printf("%5d\t%15s\t%10d\n", MainNode->id, MainNode->name, MainNode->age);
        }
        PrintTree(mode, MainNode->Pre);
        if (!(mode-'2')) {
            printf("%5d\t%15s\t%10d\n", MainNode->id, MainNode->name, MainNode->age);
        }
        PrintTree(mode, MainNode->next);
        if (!(mode-'3')) {
            printf("%5d\t%15s\t%10d\n", MainNode->id, MainNode->name, MainNode->age);
        }
    }
}

void PrintTitle()
{
    printf("%5s\t%10s\t%3s\n", "学生编号", "学生姓名", "年龄");
}

Node* CreatTree()
{
    return CreatNode(NULL, "NULL", NULL);
}

Node* CreatNode(int id, char name[], int age)
{
    Node* NewNode = (Node*)malloc(sizeof(Node));
    NewNode->id = id;
    strcpy(NewNode->name, name);
    NewNode->age = age;
    NewNode->Pre = NULL;
    NewNode->next = NULL;
    return NewNode;
}