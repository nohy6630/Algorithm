#include<bits/stdc++.h>

using namespace std;

typedef pair<int, int> pii;

int board[10][10];
int n;
pii pos[100];
bool visited[10];

bool chkBoard(int y, int x)
{
	memset(visited, false, sizeof(visited));
	for (int i = 1; i <= 9; i++)
	{
		int a = board[i][x];
		if (a > 0 && visited[a])
			return false;
		visited[a] = true;
	}
	memset(visited, false, sizeof(visited));
	for (int i = 1; i <= 9; i++)
	{
		int a = board[y][i];
		if (a > 0 && visited[a])
			return false;
		visited[a] = true;
	}
	memset(visited, false, sizeof(visited));
	int cy = 1 + (y - 1) / 3 * 3, cx = 1 + (x - 1) / 3 * 3;
	for (int i = cy; i < cy + 3; i++)
	{
		for (int j = cx; j < cx + 3; j++)
		{
			int a = board[i][j];
			if (a > 0 && visited[a])
				return false;
			visited[a] = true;
		}
	}
	return true;
}

void dfs(int depth)
{
	if (depth == n + 1)
	{
		for (int i = 1; i <= 9; i++)
		{
			for (int j = 1; j <= 9; j++)
				cout << board[i][j] << " ";
			cout << '\n';
		}
		exit(0);
	}
	for (int i = 1; i <= 9; i++)
	{
		board[pos[depth].first][pos[depth].second] = i;
		if (chkBoard(pos[depth].first, pos[depth].second))
			dfs(depth + 1);
		board[pos[depth].first][pos[depth].second] = 0;
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	for (int i = 1; i <= 9; i++)
	{
		for (int j = 1; j <= 9; j++)
		{
			cin >> board[i][j];
			if (board[i][j] == 0)
			{
				n++;
				pos[n] = { i,j };
			}
		}
	}
	dfs(1);
	return 0;
}