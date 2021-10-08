// #include <stdio.h>
// #include <stdlib.h>
// #include <string.h>
// typedef struct Student {
//     char name[20];
//     int age;
//     int id;
//     struct Student* pre;
//     struct Student* next;
// } node;

// void AddNode(int id, char name[], int age, node* MainNode);
// void Insertnode(node* posNode, node* MainNode);
// void DelNode(int age, node* MainNode);
// node* Creatnode(int id, char name[], int age);
// node* CreateTree();
// void PrintTitle();
// void PrintTree(char mode, node* MainNode);

// int main()
// {
//     node* MotherNode = CreateTree();
//     AddNode(1, "a", 9, MotherNode);
//     AddNode(2, "b", 5, MotherNode);
//     AddNode(3, "c", 4, MotherNode);
//     AddNode(4, "d", 8, MotherNode);
//     AddNode(5, "e", 4, MotherNode);
//     AddNode(6, "f", 2, MotherNode);
//     AddNode(7, "g", 7, MotherNode);
//     AddNode(8, "h", 1, MotherNode);
//     PrintTitle();
//     PrintTree('1', MotherNode);
//     return 0;
// }

// void AddNode(int id, char name[], int age, node* MainNode)
// {
//     if (!MainNode->id) {
//         MainNode->id = id;
//         strcpy(MainNode->name, name);
//         MainNode->age = age;
//     } else {
//         node* NewNode = Creatnode(id, name, age);
//         Insertnode(NewNode, MainNode);
//     }
// }

// void Insertnode(node* posNode, node* MainNode)
// {
//     if (posNode->age < MainNode->age) {
//         if (!MainNode->pre) {
//             MainNode->pre = posNode;
//         } else {
//             Insertnode(posNode, MainNode->pre);
//         }
//     } else {
//         if (!MainNode->next) {
//             MainNode->next = posNode;
//         } else {
//             Insertnode(posNode, MainNode->next);
//         }
//     }
// }

// void DelNode(int age, node* MainNode);

// node* Creatnode(int id, char name[], int age)
// {
//     node* Newnode = (node*)malloc(sizeof(node));
//     Newnode->id = id;
//     strcpy(Newnode->name, name);
//     Newnode->age = age;
//     Newnode->pre = NULL;
//     Newnode->next = NULL;
//     return Newnode;
// }

// node* CreateTree()
// {
//     return Creatnode(0, "NULL", 0);
// }

// void PrintTitle()
// {
//     printf("学生编号\t学生姓名\t年龄\n");
// }

// void PrintTree(char mode, node* MainNode)
// {
//     if (MainNode) {
//         if (mode == '1') {
//             printf("%5d\t%15s\t%5d\n", MainNode->id, MainNode->name, MainNode->age);
//         }
//         PrintTree(mode, MainNode->pre);
//         if (mode == '2') {
//             printf("%5d\t%15s\t%5d\n", MainNode->id, MainNode->name, MainNode->age);
//         }
//         PrintTree(mode, MainNode->next);
//         if (mode == '3') {
//             printf("%5d\t%15s\t%5d\n", MainNode->id, MainNode->name, MainNode->age);
//         }
//     }
// }

#include <stdio.h>

int main(int argc, char const* argv[])
{
    printf("%d", printf("Nice to see ACAT 201\b"));
    return 0;
}