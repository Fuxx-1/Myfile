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
#include <string.h>

typedef struct Huff {
    char val;
    int weight;
    struct Huff* Father;
    struct Huff* left;
    struct Huff* right;
} Node;

int Translate(int a, char b);
Node* Huff(int a, char b);

int main()
{
    char a;
    int Str[55] = { 0 }, temp;
    a = getchar();
    // 输入报文内容
    while (a != '#') {
        temp = Translate(-1, a);
        if (temp + 1) {
            Str[temp]++;
        }
        a = getchar();
    }
    for (int i = 0; i < 55; i++) {
        printf("%c: %d\n", Translate(i, NULL), Str[i]);
    }
}

int Translate(int a, char b)
{ // 字符数字转换函数
    if (b) {
        if (b >= 'A' && b <= 'Z') {
            return b - 'A' + 26;
        }
        if (b >= 'a' && b <= 'z') {
            return b - 'a';
        }
        if (b == ' ' || b == '.') {
            return b == ' ' ? 52 : 53;
        }
    }
    if (a + 1) {
        if (a < 26 && a >= 0) {
            return 'a' + a;
        }
        if (a < 52 && a > 25) {
            return 'A' + a - 26;
        }
        if (a == 52 || a == 53) {
            return a == 52 ? ' ' : '.';
        }
    }
    return -1;
}