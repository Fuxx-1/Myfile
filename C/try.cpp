#include <stdio.h>
#include <stdlib.h>

typedef struct ArcNode {
    char data;
    struct ArcNode* next;
} ArcNode;

typedef struct VexNode {
    char data;
    ArcNode* head;
} VexNode;

typedef struct Graph {
    VexNode Node[20];
    int index[26];
    int NodeNum;
    int ArcNum;
} Graph;

Graph* CreateGraph()
{
    Graph* graph = (Graph*)malloc(sizeof(Graph));
    scanf("%d%d", &graph->NodeNum, &graph->ArcNum);
    getchar();
    for (int i = 0; i < graph->NodeNum; i++) {
        graph->Node[i].data = getchar();
        graph->Node[i].head = NULL;
        graph->index[graph->Node[i].data - 'A'] = i;
    }
    getchar();
    for (int i = 0; i < graph->ArcNum; i++) {
        char a = getchar();
        if (!graph->Node[graph->index[a - 'A']].head) {
            graph->Node[graph->index[a - 'A']].head = (ArcNode*)malloc(sizeof(ArcNode));
            graph->Node[graph->index[a - 'A']].head->data = getchar();
            graph->Node[graph->index[a - 'A']].head->next = NULL;
        } else {
            ArcNode* temp = graph->Node[graph->index[a - 'A']].head;
            while (temp->next != NULL) {
                temp = temp->next;
            }
            temp->next = (ArcNode*)malloc(sizeof(ArcNode));
            temp->next->data = getchar();
            temp->next->next = NULL;
        }

        getchar();
    }
    return graph;
}

void Calculate(Graph* G)
{
    int a[25][2] = { 0 };
    for (int i = 0; i < G->NodeNum; i++) {
        ArcNode* temp = G->Node[i].head;
        while (temp != NULL) {
            a[temp->data - 'A'][1]++;
            a[i][0]++;
            temp = temp->next;
        }
    }
    for (int i = 0; i < G->NodeNum; i++) {
        printf("%c %d %d %d\n", i + 'A', a[i][0], a[i][1], a[i][0] + a[i][1]);
    }
}

void DepTravel(Graph* G, int index, int* a)
{
    if (a[index]) {
        return;
    }
    a[index] = 1;
    printf("%c", G->Node[index].data);
    ArcNode* temp = G->Node[index].head;
    while (temp != NULL) {
        DepTravel(G, temp->data - 'A', a);
        temp = temp->next;
    }
}

void WidTravel(Graph* G, char* b, int h, int t, int* a)
{
    if (a[b[h] - 'A']) {
        h++;
        if (h <= t) {
            WidTravel(G, b, h, t, a);
        }
        return;
    }
    printf("%c", G->Node[b[h] - 'A'].data);
    a[b[h] - 'A'] = 1;
    ArcNode* temp = G->Node[b[h++] - 'A'].head;
    while (temp != NULL) {
        b[++t] = temp->data;
        temp = temp->next;
    }
    if (h <= t) {
        WidTravel(G, b, h, t, a);
    }
}

int main(int argc, char const* argv[])
{
    Graph* Head = CreateGraph();
    Calculate(Head);
    int a[30] = { 0 };
    DepTravel(Head, 0, a);
    printf("\n");
    int c[30] = { 0 };
    char b[50] = { 0 };
    b[0] = Head->Node[0].data;
    WidTravel(Head, b, 0, 0, c);
    return 0;
}
