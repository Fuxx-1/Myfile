// // #include <stdio.h>
// // #include <stdlib.h>
// // #include <string.h>

// // int* InitStack(int maxsize); //初始化
// // int IsEmptyStack(int a[]); //判空
// // int InStack(int a[], int x); //入栈
// // int OutStack(int a[]); //出栈
// // int getLengthOfStack(int a[]); //获得栈内存放元素个数
// // int goToNext(int* X, int* Y, int** a, int* Stack, int flag); //走向下一个
// // int recall(int* X, int* Y, int** a, int* Stack); //回溯
// // void printResult(int** a); //打印结果
// // int HorseOnChessboard(int X, int Y, int** a, int* Stack);

// // int main(void)
// // {
// //     int Horse[8][8] = { 0 };
// //     int X, Y;
// //     scanf("%d%d", &X, &Y);
// //     int* Stack = InitStack(75);
// //     HorseOnChessboard(X - 1, Y - 1, (int**)Horse, Stack);
// //     return 0;
// // }

// // int action[8][2] = {
// //     { -2, 1 },
// //     { -1, 2 },
// //     { 1, 2 },
// //     { 2, 1 },
// //     { 2, -1 },
// //     { 1, -2 },
// //     { -1, -2 },
// //     { -2, -1 }
// // };

// // int HorseOnChessboard(int X, int Y, int** a, int* Stack)
// // {
// //     *((int*)a + X * 8 + Y) = 1;
// //     InStack(Stack, -1);
// //     while (getLengthOfStack(Stack) != 64) {
// //         if (!goToNext(&X, &Y, a, Stack, 0)) {
// //             int temp = 0;
// //             while (!goToNext(&X, &Y, a, Stack, temp + 1)) {
// //                 temp = recall(&X, &Y, a, Stack);
// //             }
// //         }
// //     }
// //     printResult(a);
// // }
// // int goToNext(int* X, int* Y, int** a, int* Stack, int flag) //走向下一个
// // {
// //     for (int i = flag; i < 8; i++) {
// //         int tempX = *X + action[i][0];
// //         int tempY = *Y + action[i][1];
// //         if (tempX < 8 && tempX >= 0 && tempY < 8 && tempY >= 0 && *((int*)a + tempX * 8 + tempY) == 0) {
// //             InStack(Stack, i);
// //             *((int*)a + tempX * 8 + tempY) = getLengthOfStack(Stack);
// //             *X = tempX;
// //             *Y = tempY;
// //             return 1;
// //         }
// //     }
// //     return 0;
// // }
// // int recall(int* X, int* Y, int** a, int* Stack) //回溯
// // {
// //     int valTemp = OutStack(Stack);
// //     *((int*)a + *X * 8 + *Y) = 0;
// //     *X -= action[valTemp][0];
// //     *Y -= action[valTemp][1];
// //     return valTemp;
// // }
// // void printResult(int** a) //打印结果
// // {
// //     for (int i = 0; i < 8; i++) {
// //         for (int j = 0; j < 8; j++) {
// //             printf("%2d ", *((int*)a + i * 8 + j));
// //         }
// //         printf("\n");
// //     }
// // }

// // int* InitStack(int maxsize)
// // {
// //     int* newStack;
// //     newStack = (int*)malloc(sizeof(int) * maxsize);
// //     newStack[0] = 0; //newStack[0]为元素个数
// //     return newStack;
// // }
// // int IsEmptyStack(int a[])
// // {
// //     if (a[0] + 1) {
// //         return 0;
// //     } else {
// //         return 1;
// //     }
// // }
// // int InStack(int a[], int x)
// // { //默认不会失败
// //     a[++a[0]] = x;
// //     return 1;
// // }
// // int OutStack(int a[])
// // {
// //     int temp = -1;
// //     if (IsEmptyStack(a)) {
// //         return temp;
// //     } else {
// //         temp = a[a[0]];
// //         a[a[0]--] = 0;
// //         return temp;
// //     }
// // }
// // int getLengthOfStack(int a[])
// // {
// //     return a[0];
// // }

// #include <stdio.h>
// #define N 10
// int main()
// {
//     int length;
//     scanf("%d", &length);
//     int a[length];
//     for (int i = 0; i < length; i++) {
//         scanf("%d", &a[i]);
//     }
//     /* 以上为定义及输入，输入的数组名为a，长度为length */

//     /* 以下为输出 */
//     for (int i = 0; i < length; i++) {
//         printf("%d ", a[i]);
//     }
// }

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Huff {
    char val;
    int weight;
    struct Huff* Father;
    struct Huff* left;
    struct Huff* right;
} Node;

int Translate(int a, char b);
Node* HuffTree(Node** temp);
Node* CreateFatherNode(Node* Left, Node* Right);
void Search(Node* root, char val, int* a, int length);
void PrintTree(Node* bt, int h)
{
    if (bt == NULL)
        return;
    PrintTree(bt->left, h + 1);
    for (int i = 0; i < h; i++)
        printf("  ");
    printf("%c\n", bt->val ? bt->val : '空');
    PrintTree(bt->right, h + 1);
}

int main()
{
    Node* Temp[54] = { NULL };
    char a, Str1[201];
    int Str[55] = { 0 }, temp, temp1 = 0;
    a = getchar();
    // 输入报文内容
    while (a != '#') {
        temp = Translate(-1, a);
        if (temp + 1) {
            Str[temp]++;
        }
        Str1[temp1++] = a;
        a = getchar();
    }
    for (int i = 0; i < 54; i++) {
        Temp[i] = (Node*)malloc(sizeof(Node));
        Temp[i]->val = Translate(i, NULL);
        Temp[i]->weight = Str[i];
        Temp[i]->Father = NULL;
        Temp[i]->left = NULL;
        Temp[i]->right = NULL;
    }
    for (int i = 0; i < 54 - 1; i++) {
        for (int j = 0; j < 54 - i - 1; j++) {
            if (Temp[j]->weight < Temp[j + 1]->weight) {
                Node* Nodetemp = Temp[j];
                Temp[j] = Temp[j + 1];
                Temp[j + 1] = Nodetemp;
            } else if (Temp[j]->weight == Temp[j + 1]->weight && Temp[j]->val < Temp[j + 1]->val) {
                Node* Nodetemp = Temp[j];
                Temp[j] = Temp[j + 1];
                Temp[j + 1] = Nodetemp;
            }
        }
    }
    // for (int i = 0; i < 54; i++) {
    //     if (Temp[i]->weight != 0) {
    //         printf("%c: %d\n", Temp[i]->val, Temp[i]->weight);
    //     }
    // }
    Node* root = HuffTree(Temp);
    // PrintTree(root, 0);
    //编码
    int length = strlen(Str1);
    int lengthtemp = 0;
    while (lengthtemp < length) {
        // printf("%c:", Str1[lengthtemp]);
        Search(root, Str1[lengthtemp], Str, 0);
        // printf("\n");
        lengthtemp++;
    }
    printf("\n");
    Node* NodeTemp = root;
    a = getchar();
    while (scanf("%c", &a) != EOF) {
        if (a == '1') {
            NodeTemp = NodeTemp->left;
        } else {
            NodeTemp = NodeTemp->right;
        }
        if (NodeTemp->val) {
            printf("%c", NodeTemp->val);
            NodeTemp = root;
        }
    }
   
}

int Translate(int a, char b)
{ // 字符数字转换函数
    if (b) {
        if (b >= 'A' && b <= 'Z') {
            return b - 'A' + 2;
        }
        if (b >= 'a' && b <= 'z') {
            return b - 'a' + 28;
        }
        if (b == ' ' || b == '.') {
            return b == ' ' ? 0 : 1;
        }
    }
    if (a + 1) {
        if (a < 28 && a >= 2) {
            return 'A' + a - 2;
        }
        if (a < 54 && a > 27) {
            return 'a' + a - 28;
        }
        if (a == 0 || a == 1) {
            return a == 0 ? ' ' : '.';
        }
    }
    return -1;
}

Node* HuffTree(Node* temp[])
{ // 创建哈夫曼树并返回根节点
    int flag = 0;
    while (temp[flag + 1]->weight != 0) {
        flag++;
    }
    while (flag) {
        // 生成父节点
        Node* Father = CreateFatherNode(temp[flag--], temp[flag--]);
        if (!(flag + 1)) {
            return Father;
        }
        // 将父节点插入结构体链表
        for (int i = ++flag; i >= 1; i--) {
            temp[i] = temp[i - 1];
            if (Father->weight < temp[i - 1]->weight) {
                temp[i] = Father;
                break;
            } else if (i == 1 && Father->weight >= temp[i - 1]->weight) {
                temp[i - 1] = Father;
            }
        }
        // for (int i = 0; i < 54; i++) {
        //     if (temp[i]->weight != 0) {
        //         printf("%d ", temp[i]->weight);
        //     }
        // }
        // printf("\n");
    }
}
Node* CreateFatherNode(Node* Left, Node* Right)
{
    Node* Father = (Node*)malloc(sizeof(Node));
    Father->weight = Left->weight + Right->weight;
    Father->val = NULL;
    Father->Father = NULL;
    Father->left = Left;
    Father->right = Right;
    Left->Father = Father;
    Right->Father = Father;
    return Father;
}
void Search(Node* root, char val, int* a, int length)
{
    if (root) {
        if (root->val && root->val == val) {
            for (int i = 0; i < length; i++) {
                printf("%d", a[i]);
            }
            return;
        } else {
            a[length] = 1;
            Search(root->left, val, a, length + 1);
            a[length] = 0;
            Search(root->right, val, a, length + 1);
        }
    } else {
        return;
    }
}
