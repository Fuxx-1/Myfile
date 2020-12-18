#include <stdio.h>
int k = 1;
int move(char getone, int n, char putone)
{
    k++;
    return 0;
}
int hanoi(int n, char x, char y, char z)
{
    if (n == 1)
        move(x, 1, z);
    else
    {
        hanoi(n - 1, x, z, y);
        move(x, n, z);
        hanoi(n - 1, y, x, z);
    }
    return 0;
}
int main()
{
    int n, counter;
    scanf("%d", &n);
    counter = hanoi(n, 'A', 'B', 'C');
    printf("%d\n", k - 1);
    return 0;
}
