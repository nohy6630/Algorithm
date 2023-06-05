#include <bits/stdc++.h>

using namespace std;
typedef pair<int, int> pii;

int N, M;
char board[51][51];
vector<pii> A, B;
int dist[101][101], d[101][101], park[201], visited[201];
int dx[4] = {0, 0, 1, -1};
int dy[4] = {1, -1, 0, 0};
vector<int> G[201];

bool dfs(int v)
{
    visited[v] = true;
    for (auto adj : G[v])
    {
        if (visited[adj])
            continue;
        visited[adj] = true;
        if (park[adj] == -1 || dfs(park[adj]))
        {
            park[adj] = v;
            return true;
        }
    }
    return false;
}

bool isValid(int t)
{
    for (int i = 0; i < 201; i++)
        G[i].clear();
    for (int i = 1; i < A.size(); i++)
    {
        for (int j = 1; j < B.size(); j++)
        {
            if (dist[i][j] != -1 && dist[i][j] <= t)
                G[i].push_back(j+100);
        }
    }
    int cnt = 0;
    memset(park, -1, sizeof(park));
    for (int i = 1; i < A.size(); i++)
    {
        memset(visited, 0, sizeof(visited));
        cnt += dfs(i);
    }
    return cnt == A.size() - 1;
}

void bfs(int s)
{
    memset(d, -1, sizeof(d));
    queue<pii> Q;
    Q.push(A[s]);
    d[A[s].first][A[s].second] = 0;
    while (!Q.empty())
    {
        int x = Q.front().first, y = Q.front().second;
        Q.pop();
        for (int k = 0; k < 4; k++)
        {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx < 1 || ny < 1 || nx > N || ny > M)
                continue;
            if (d[nx][ny] != -1)
                continue;
            if (board[nx][ny] == 'X')
                continue;
            d[nx][ny] = d[x][y] + 1;
            Q.push({nx, ny});
        }
    }
    for (int i = 1; i < B.size(); i++)
        dist[s][i] = d[B[i].first][B[i].second];
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    A.push_back({-1, -1});
    B.push_back({-1, -1});
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= M; j++)
        {
            cin >> board[i][j];
            if (board[i][j] == 'C')
                A.push_back({i, j});
            if (board[i][j] == 'P')
                B.push_back({i, j});
        }
    }
    if (A.size() > B.size())
    {
        cout << -1;
        return 0;
    }
    if (A.size() == 1)
    {
        cout << 0;
        return 0;
    }
    for (int i = 1; i < A.size(); i++)
        bfs(i);
    int ans = -1, l = 0, r = 10000;
    while (l <= r)
    {
        int m = (l + r) / 2;
        if (isValid(m))
        {
            ans = m;
            r = m - 1;
        }
        else
            l = m + 1;
    }
    cout << ans;
}