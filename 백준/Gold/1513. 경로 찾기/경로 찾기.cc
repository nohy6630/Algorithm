#include <iostream>
#include <algorithm>
#include <cstring>
#include <cstdio>
#define MAX 50
#define MOD 1000007

using namespace std;

int N, M, C;
int in[MAX + 1][MAX + 1];
int dp[MAX + 1][MAX + 1][MAX + 1][MAX + 1];

int get_dp(int y, int x, int cnt, int recent) {
	if (y < 1 || x < 1 || cnt < 0)
		return 0;
	if (dp[y][x][cnt][recent] != -1)
		return dp[y][x][cnt][recent];
	if (!in[y][x])
		dp[y][x][cnt][recent] = (get_dp(y - 1, x, cnt, recent) + get_dp(y, x - 1, cnt, recent)) % MOD;
	else if (in[y][x] == recent) {
		dp[y][x][cnt][recent] = 0;
		for (int i = 0; i < recent; i++)
			dp[y][x][cnt][recent] = (dp[y][x][cnt][recent] + get_dp(y - 1, x, cnt - 1, i) + get_dp(y, x - 1, cnt - 1, i)) % MOD;
	}
	else
		dp[y][x][cnt][recent] = 0;
	return dp[y][x][cnt][recent];
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> M >> C;
	for (int i = 1; i <= C; i++) {
		int a, b;
		cin >> a >> b;
		in[b][a] = i;
	}

	for (int i = 0; i <= C; i++) {
		int ans = 0;
		memset(dp, -1, sizeof(dp));
		if (!in[1][1])
			dp[1][1][0][0] = 1;
		else
			dp[1][1][1][in[1][1]] = 1;
		for (int j = i; j <= C; j++)
			ans = (ans + get_dp(M, N, i, j)) % MOD;
		cout << ans << " ";
	}
	return 0;
}
