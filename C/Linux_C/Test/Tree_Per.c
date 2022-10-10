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
void Del(char mode[], Node* MainNode);
void DelNode(Node* PosNode, Node FatherNode);
void PrintTree(char mode[], Node* MainNode);
void PrintTitle();
Node* CreatTree();
Node* CreatNode(int id, char age[], int age);

int main(int argc, char const* argv[])
{
    /* code */
    return 0;
}

Node* CreatTree()
{
    return CreatNode(NULL, NULL, NULL);
}

void AddNode(int id, char name[], int age, Node* MainNode);
{
    Node* NewNode = CreatNode(id, name, age);
    InsertNode(NewNode, MainNode);
}

Node* CreatNode(int id, char age[], int age)
{
    Node* NewNode = (Node*)malloc(sizeof(Node));
    NewNode.
}

void InsertNode(Node* PosNode, Node* MainNode)
{

}

void Del(char mode[], Node* MainNode);
void DelNode(Node* PosNode, Node FatherNode);
void PrintTree(char mode[], Node* MainNode);
void PrintTitle();
