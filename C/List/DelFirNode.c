#include <stdio.h>
typedef struct Val {
    int val;
} Node;

void DelNode(Node** p);
void PrintNode(Node* p);

int main(int argc, char const* argv[])
{
    Node a[10] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    Node* p = a;
    PrintNode(p);
    DelNode(&p);
    PrintNode(p);
    return 0;
}

void DelNode(Node** p)
{
    Node* temp;
    temp = *p;
    *p++;
    free(temp);
}

void PrintNode(Node* p)
{
    for (int i = 0; i < 9; i++) {
        printf("%d ", p->val);
        p++;
    }
}
