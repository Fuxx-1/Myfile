#include <stdio.h>
#include <stdlib.h>
typedef struct Node
{
    int data;
    struct Node *pNext;
} NODE, *PNODE;
PNODE creat_list(void)
{
    int val;
    int i;
    int len;
    PNODE pHead = (PNODE)malloc(sizeof(NODE));
    if (pHead == NULL)
    {
        printf("分配失败，程序退出！\n");
        exit(-1);
    }
    PNODE pTail = pHead;
    pTail->pNext = NULL;
    printf("请输入链节长度：");
    scanf("%d", &len);
    for (i = 0; i < len; ++i)
    {
        printf("第%d个数为：\n", i + 1);
        scanf("%d", &val);
        PNODE pNew = (PNODE)malloc(sizeof(NODE));
        if (pNew == NULL)
        {
            printf("分配失败，程序退出\n");
            exit(-1);
        }
        pNew->data = val;
        pTail->pNext = pNew;
        pNew->pNext = NULL;
        pTail = pNew;
    }

    return pHead;
}
void traverse_list(PNODE pHead)
{
    PNODE p = pHead->pNext;
    while (p->pNext != NULL)
    {
        printf("%d", p->data);
        p = p->pNext;
    }
}

int main(void)
{
    PNODE pHead = NULL;
    pHead = creat_list();
    traverse_list(pHead);
    return 0;
}