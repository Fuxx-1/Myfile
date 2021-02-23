#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;

typedef long long ll;

ll n, ans;

void dfs(ll wei, ll tot)
{ //wei表示当前的tot总共有多少位。
	if (ans != -1)
		return;
	if (wei > 19)
		return;
	if (tot % n == 0)
	{
		ans = tot;
		return;
	}
	dfs(wei + 1, tot * 10);
	dfs(wei + 1, tot * 10 + 1);
}

int main()
{

	while (~scanf("%lld", &n) && n)
	{

		ans = -1;
		dfs(1, 1);
		printf("%lld\n", ans);
	}

	return 0;
}