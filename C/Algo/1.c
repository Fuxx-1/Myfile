#include <stdio.h>
#include <stdlib.h>
#define MAX 1000

int a[MAX] = { 0 };

int main(int argc, char const* argv[])
{
    int num;
    scanf("%d", &num);
    solve(num);
    return 0;
}

void solve(int num)
{
    for (int i = 1; i <= num; i++) {
        a[0] = i;
        rec(num, i, 0);
    }
    return;
}

void rec(int num, int sum, int offset)
{
    if (sum != num) {
        int max = a[offset], i = 1;
        while (i + sum <= num && i <= max) {
            a[++offset] = i;
            rec(num, sum + i, offset);
            a[offset--] = 0;
            i++;
        }
    } else {
        for (int i = 0; i <= offset; i++) {
            printf("%d ", a[i]);
        }
        printf("\n");
        return;
    }
    return;
}