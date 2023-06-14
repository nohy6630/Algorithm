#include<bits/stdc++.h>
#define Y first
#define X second

using namespace std;

typedef pair<int,int> pii;

int N,M;
int board[51][51];
int X;
vector<pii> virus;
int dx[]={-1,1,0,0};
int dy[]={0,0,-1,1};
int ans = INT_MAX;
int t[51][51];

int bfs()
{
	int tmp=0;
	queue<pii> Q;
	memset(t,-1,sizeof(t));
	for(int i=1;i<=virus.size();i++)
	{
		if(X&(1<<i))
		{
			Q.push(virus[i-1]);
			t[virus[i-1].Y][virus[i-1].X]=0;
		}
	}
	while(!Q.empty())
	{
		int x=Q.front().X, y=Q.front().Y;
		Q.pop();
		for(int i=0;i<4;i++)
		{
			int nx=x+dx[i],ny=y+dy[i];
			if(nx<1||nx>N||ny<1||ny>N||t[ny][nx]>=0||board[ny][nx]==1)
				continue;
			t[ny][nx]=t[y][x]+1;
			tmp=max(tmp,t[ny][nx]);
			Q.push({ny,nx});
		}
	}
	//cout<<"dfs: "<<tmp<<'\n';
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=N;j++)
		{
			if(board[i][j]!=1&&t[i][j]==-1)
				return INT_MAX;
		}
	}
	return tmp;
}

void dfs(int depth,int k)
{
	if(k==M)
	{
		//cout<<X<<'\n';
		ans=min(ans,bfs());		
		return;
	}
	if(depth>virus.size())
		return;
	X|=(1<<depth);
	dfs(depth+1,k+1);
	X&=~(1<<depth);
	dfs(depth+1,k);
}

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>N>>M;
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=N;j++)
		{
			cin>>board[i][j];
			if(board[i][j]==2)
				virus.push_back({i,j});
		}
	}
	dfs(1,0);
	if(ans==INT_MAX)
		cout<<-1;
	else
		cout<<ans;
}