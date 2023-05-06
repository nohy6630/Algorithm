#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> pii;

int T,M,N,C;
int board[51][51];
bool visited[51][51];
int dy[4]={0,-1,0,1};
int dx[4]={-1,0,1,0};

void dfs(int y,int x)
{
	visited[y][x]=true;
	for(int i=0;i<4;i++)
	{
		int ny=y+dy[i],nx=x+dx[i];
		if(nx<0||ny<0||nx>=M||ny>=N)
			continue;
		if(!board[ny][nx]||visited[ny][nx])
			continue;
		dfs(ny,nx);
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>T;
	for(int i=0;i<T;i++)
	{
		memset(visited,false,sizeof(visited));
		memset(board,0,sizeof(board));
		int cnt=0;
		cin>>M>>N>>C;
		for(int j=1;j<=C;j++)
		{
			int a,b;
			cin>>a>>b;
			board[b][a]=1;
		}
		for(int j=0;j<N;j++)
		{
			for(int k=0;k<M;k++)
			{
				if(!board[j][k]||visited[j][k])
					continue;
				dfs(j,k);
				cnt++;
			}
		}
		cout<<cnt<<'\n';
	}
}