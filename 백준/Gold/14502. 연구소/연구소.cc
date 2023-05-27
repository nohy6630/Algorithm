#include<bits/stdc++.h>
#define F first
#define S second

using namespace std;

typedef pair<int,int> pii;

int N,M;
int board[9][9];
bool visited[9][9];
int ans=INT_MIN;
int dy[4]={0,-1,0,1};
int dx[4]={-1,0,1,0};
int wall=0;

int dfs(int y,int x)
{
	int ret=1;
	visited[y][x]=true;
	for(int i=0;i<4;i++)
	{
		int ny=y+dy[i],nx=x+dx[i];
		if(ny<1||ny>N||nx<1||nx>M)
			continue;
		if(!visited[ny][nx]&&board[ny][nx]!=1)
			ret+=dfs(ny,nx);
	}
	return ret;
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	for(int i=1;i<=N;i++)
		for(int j=1;j<=M;j++)
		{
			cin>>board[i][j];
			if(board[i][j]==1)
				wall++;
		}
	for(int i=0;i<N*M;i++)
	{
		if(board[1+i/M][1+i%M]!=0)
			continue;
		for(int j=i+1;j<N*M;j++)
		{
			if(board[1+j/M][1+j%M]!=0)
				continue;
			for(int k=j+1;k<N*M;k++)
			{
				if(board[1+k/M][1+k%M]!=0)
					continue;
				pii p[3]={{1+i/M,1+i%M},{1+j/M,1+j%M},{1+k/M,1+k%M}};//N이 아니라 M에 의해 인덱스가 정해져야됨. M이 한 행에 잇는 인덱스의 갯수이니 
				for(auto pos:p)
				{
					board[pos.F][pos.S]=1;
					//cout<<pos.F<<','<<pos.S<<'\n';
				}
				//cout<<'\n'; 
				memset(visited,false,sizeof(visited));
				int cur=0;
				for(int y=1;y<=N;y++)
					for(int x=1;x<=M;x++)
						if(!visited[y][x]&&board[y][x]==2)
							cur+=dfs(y,x);
				ans=max(ans,N*M-wall-3-cur);
				for(auto pos:p)
					board[pos.F][pos.S]=0;
			}
		}
	}
	cout<<ans;
}