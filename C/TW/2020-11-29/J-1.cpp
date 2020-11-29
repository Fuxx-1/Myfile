#include <cstdio>
#include <cstring>
#include <algorithm>
#include <map>
#include <queue>
#include <iostream>

using namespace std;
typedef long long ll;

int a[2000000];
int main()
{
    int T;
    scanf("%d", &T);
    while (T--)
    {
        int n;
        scanf("%d", &n);
        printf("%d\n", 2);
        int now = n;
        for (int i = n - 1; i >= 1; i--)
        {
            printf("%d %d\n", i, now);
            now = (i + now + 1) / 2;
        }
    }
    return 0;
}
