#include <iostream>
#include <algorithm>
#include <cstring>
#define MAX 500

using namespace std;

int n, ans;
int tree[MAX + 1][MAX + 1];
int dp[MAX + 1][MAX + 1];
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, -1, 0, 1};

int get_dp(int x, int y)
{
    if (dp[y][x] != -1)
        return dp[y][x];
    dp[y][x] = 1;
    for (int i = 0; i < 4; i++)
    {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 1 || nx > n || ny < 1 || ny > n)
            continue;
        if (tree[ny][nx] < tree[y][x])
            dp[y][x] = max(dp[y][x], get_dp(nx, ny) + 1);
    }
    return dp[y][x];
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> n;
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            cin >> tree[i][j];
    memset(dp, -1, sizeof(dp));
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= n; j++)
            ans = max(ans, get_dp(j, i));
    cout << ans;
    return 0;
}