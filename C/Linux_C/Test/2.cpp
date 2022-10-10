#include <bits/stdc++.h>
using namespace std;
int ti[1005], pri[1005];
int f[1005][1005];
int main()
{
    int t, m;
    cin >> t >> m;
    for (int i = 1; i <= m; ++i)
    {
        cin >> ti[i] >> pri[i];
        for (int j = t; j >= 0; j--)
        {
            f[i][j] = f[i - 1][j];
            if (j >= ti[i])
                f[i][j] = max(f[i][j], f[i - 1][j - ti[i]] + pri[i]);
        }
    }
    cout << f[m][t];
    return 0;
}