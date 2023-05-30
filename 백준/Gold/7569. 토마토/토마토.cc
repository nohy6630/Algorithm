/*
이문제같은경우노드의접근순서가정해져있기때문에dfs가아닌무조건bfs를이용하여그래프를탐색해야한다.
*/

#include "bits/stdc++.h"
using namespace std;

struct Pos
{
    int x, y, z;
};

int M, N, H;
int board[101][101][101]; // 4MB
bool visited[101][101][101];
queue<Pos> Q;
int dy[6] = {0, -1, 0, 1, 0, 0};
int dx[6] = {-1, 0, 1, 0, 0, 0};
int dz[6] = {0, 0, 0, 0, 1, -1};
int ans = 0;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> M >> N >> H;
    for (int k = 1; k <= H; k++)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= M; j++)
            {
                cin >> board[k][i][j];
                if (board[k][i][j] == 1)
                {
                    Q.push({j, i, k});
                    visited[k][i][j] = true;
                }
            }
        }
    }
    while (!Q.empty())
    {
        Pos cur = Q.front();
        Q.pop();
        for (int i = 0; i < 6; i++)
        {
            int nx = cur.x + dx[i], ny = cur.y + dy[i], nz = cur.z + dz[i];
            if (nx < 1 || nx > M || ny < 1 || ny > N || nz < 1 || nz > H)
                continue;
            if (visited[nz][ny][nx] || board[nz][ny][nx] == -1)
                continue;
            Q.push({nx, ny, nz});
            visited[nz][ny][nx] = true;
            board[nz][ny][nx] = board[cur.z][cur.y][cur.x] + 1;
            ans = max(ans, board[nz][ny][nx]-1);
        }
    }
    for (int k = 1; k <= H; k++)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= M; j++)
            {
                if (board[k][i][j] == 0)
                {
                    cout << -1;
                    return 0;
                }
            }
        }
    }
    cout << ans;
}