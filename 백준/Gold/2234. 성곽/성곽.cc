/*
그냥 단순히 dfs돌려도 n이 적기 때문에 괜춘
그리고 하나의벽을 제거하여 최대 방의 크기를 구하는건 이 역시도 n^2시간복잡도라 해봤자 2500*4 이므로
완전탐색방법을 이용하여 모든 벽을 제거해보고 최대방의 크기를 구하자
*/
#include<bits/stdc++.h>

using namespace std;
typedef pair<int, int> pii;

int N, M;
int board[51][51];
bool visited[51][51];
int dy[4] = { 0,-1,0,1 };
int dx[4] = { -1,0,1,0 };

int dfs(int y, int x)
{
	if (y<1 || x<1 || y>M || x>N)
		return 0;
	visited[y][x] = true;
	int area = 1;
	for (int i = 0; i < 4; i++)
	{
		printf("");
		if (!(board[y][x] & (1 << i)) && !visited[y + dy[i]][x + dx[i]])
		{
			printf("");
			area += dfs(y + dy[i], x + dx[i]);
			printf("");

		}
	}
	return area;
}

pii get_info()
{
	int cnt = 0, area = INT_MIN;
	memset(visited, false, sizeof(visited));
	for (int i = 1; i <= M; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			if (!visited[i][j])
			{
				area = max(area, dfs(i, j));
				cnt++;
			}
		}
	}
	return { cnt,area };
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> M;
	for (int i = 1; i <= M; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			cin >> board[i][j];
		}
	}
	pii p = get_info();
	int area = INT_MIN;
	for (int i = 1; i <= M; i++)
	{
		for (int j = 1; j <= N; j++)
		{
			for (int k = 0; k < 4; k++)
			{
				if (board[i][j] & (1 << k))
				{
					board[i][j] &= ~(1 << k);
					area = max(area, get_info().second);
					board[i][j] |= 1 << k;
				}
			}
		}
	}
	cout << p.first << '\n' << p.second << '\n' << area << '\n';
}