#include<bits/stdc++.h>

using namespace std;

int N;
int board[101][101];
int idx=1;
int id[101][101];
bool visited[101][101];
int dy[]={-1,1,0,0};
int dx[]={0,0,-1,1};

void dfs(int y,int x)
{
	if(visited[y][x])
		return;
	visited[y][x]=true;
	id[y][x]=idx;
	for(int i=0;i<4;i++)
	{
		int ny=y+dy[i],nx=x+dx[i];
		if(ny<1||nx<1||ny>N||nx>N||board[ny][nx]==0)
			continue;
		dfs(ny,nx);
	}
}

int bfs(int y,int x)
{
	memset(visited,false,sizeof(visited));
	queue<pair<int,pair<int,int>>> Q;
	Q.push({0,{y,x}});
	visited[y][x]=true;
	while(!Q.empty())
	{
		int d=Q.front().first;
		int cy=Q.front().second.first;
		int cx=Q.front().second.second;
		Q.pop();
		for(int i=0;i<4;i++)
		{
			int ny=cy+dy[i],nx=cx+dx[i];
			if(ny<1||nx<1||ny>N||nx>N||visited[ny][nx])
				continue;
			if(id[ny][nx]!=0&&id[y][x]!=id[ny][nx])
				return d+1;
			Q.push({d+1,{ny,nx}});
			visited[ny][nx]=true;
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>N;
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=N;j++)
		{
			cin>>board[i][j];
		}
	}
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=N;j++)
		{
			if(board[i][j]==1&&!visited[i][j])
			{
				dfs(i,j);
				idx++;
			}
		}
	}
	int ans=INT_MAX;
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=N;j++)
		{
			if(board[i][j]==0)
				continue;
			ans=min(ans,bfs(i,j)-1);
		}
	}
	cout<<ans;
}