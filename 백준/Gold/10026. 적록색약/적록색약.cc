#include<bits/stdc++.h>
#define F first
#define S second

using namespace std;
typedef pair<int,int> pii;

int N;
char board[101][101];
bool visited[101][101];
int cnt[2];
int dy[4]={0,-1,0,1};
int dx[4]={-1,0,1,0};

void dfs(int y,int x)
{
	visited[y][x]=true;
	for(int i=0;i<4;i++)
	{
		int ny=y+dy[i],nx=x+dx[i];
		if(nx<1||nx>N||ny<1||ny>N)
			continue;
		if(!visited[ny][nx]&&board[ny][nx]==board[y][x])
			dfs(ny,nx);
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=1;i<=N;i++)
	{
		string s;
		cin>>s;
		for(int j=0;j<s.size();j++)
			board[i][j+1]=s[j];
	}
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=N;j++)
		{
			if(!visited[i][j])
			{
				cnt[0]++;
				dfs(i,j);
			}
		}
	}
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=N;j++)
		{
			if(board[i][j]=='G')
				board[i][j]='R';
		}
	}
	memset(visited,0,sizeof(visited));
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=N;j++)
		{
			if(!visited[i][j])
			{
				cnt[1]++;
				dfs(i,j);
			}
		}
	}
	cout<<cnt[0]<<' '<<cnt[1];
}