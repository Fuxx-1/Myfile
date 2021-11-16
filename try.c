// // // #include <stdio.h>
// // // int main(int argc, char const* argv[])
// // // {
// // // #ifdef __linux__
// // //     puts("It is in Linux OS!");
// // // #endif
// // // #ifdef __WINDOWS_
// // //     puts("It is in Windows OS!");
// // // #endif
// // // #ifdef _WIN32
// // //     puts("It is in Windows32 OS!");
// // // #endif
// // //     return 0;
// // // }
// // #include <stdio.h>
// // #include <stdlib.h>

// // typedef struct Node {
// //     int data;
// //     struct Node* lchild;
// //     struct Node* rchild;
// // } node;

// // typedef struct Node2 //树根
// // {
// //     node* root;
// // } Tree;

// // /*二叉树前序遍历递归算法*/
// // void PreOrderTraverse(node* T)
// // {
// //     if (T == NULL) {
// //         return;
// //     }
// //     printf("%d ", T->data);
// //     PreOrderTraverse(T->lchild);
// //     PreOrderTraverse(T->rchild);
// // }
// // /*二叉树中序遍历递归算法*/
// // void InOrderTraverse(node* T)
// // {
// //     if (T == NULL) {
// //         return;
// //     }
// //     InOrderTraverse(T->lchild);
// //     printf("%d ", T->data);
// //     InOrderTraverse(T->rchild);
// // }

// // /*二叉树序后遍历递归算法*/
// // void PostOrderTraverse(node* T)
// // {
// //     if (T == NULL)
// //         return;
// //     PostOrderTraverse(T->lchild);
// //     PostOrderTraverse(T->rchild);
// //     printf("%d ", T->data);
// // }

// // void insert(Tree* tree, int value) //创建树
// // {
// //     node* p = (node*)malloc(sizeof(node)); //创建一个节点
// //     p->data = value;
// //     p->lchild = NULL;
// //     p->rchild = NULL;
// //     if (tree->root == NULL) //判断树是不是空树
// //     {
// //         tree->root = p;
// //     } else { //不是空树
// //         node* temp = tree->root; //从树根开始
// //         while (temp != NULL) {
// //             if (value < temp->data) //小于就进左儿子
// //             {
// //                 if (temp->lchild == NULL) {
// //                     temp->lchild = p;
// //                     return;
// //                 } else { //继续判断
// //                     temp = temp->lchild;
// //                 }
// //             } else { //否则进右儿子
// //                 if (temp->rchild == NULL)

// //                 {
// //                     temp->rchild = p;
// //                     return;

// //                 } else { //继续判断
// //                     temp = temp->rchild;
// //                 }
// //             }
// //         }
// //     }
// //     return;
// // }

// // int main()
// // {
// //     Tree tree;
// //     tree.root = NULL; //创建一个空树
// //     int n;
// //     printf("请输入要创建的结点数：\n");
// //     scanf("%d", &n);
// //     for (int i = 0; i < n; i++) { //输入n个数并创建这个树
// //         int temp;
// //         scanf("%d", &temp);
// //         insert(&tree, temp);
// //     }
// //     PreOrderTraverse(tree.root);
// //     printf("\n");
// //     InOrderTraverse(tree.root);
// //     printf("\n");
// //     PostOrderTraverse(tree.root);
// //     return 0;
// // }

// #include <stdio.h>
// #include <stdlib.h>

// typedef struct TreeNode {
//     char data;
//     struct Node* Lchild;
//     struct Node* Rchild;
// } Node;

// Node* CreatTree();
// void PrintFront(Node* root);
// void PrintIn(Node* root);
// void PrintEnd(Node* root);

// int main(void)
// {
//     Node* root;
//     root = CreatTree();
//     PrintFront(root);
//     printf("\n");
//     PrintIn(root);
//     printf("\n");
//     PrintEnd(root);
// }

// Node* CreatTree()
// {
//     Node* bt;
//     char ch;
//     ch = getchar();
//     if (ch == '#') {
//         return NULL;
//     }
//     bt = (Node*)malloc(sizeof(Node));
//     bt->data = ch;
//     bt->Lchild = CreatTree();
//     bt->Rchild = CreatTree();
//     return bt;
// }
// void PrintFront(Node* root)
// {
//     if (root) {
//         printf("%c", root->data);
//         PrintFront(root->Lchild);
//         PrintFront(root->Rchild);
//     }
// }
// void PrintIn(Node* root)
// {
//     if (root) {
//         PrintIn(root->Lchild);
//         printf("%c", root->data);
//         PrintIn(root->Rchild);
//     }
// }
// void PrintEnd(Node* root)
// {
//     if (root) {
//         PrintEnd(root->Lchild);
//         PrintEnd(root->Rchild);
//         printf("%c", root->data);
//     }
// }
