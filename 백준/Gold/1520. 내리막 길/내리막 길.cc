#include<bits/stdc++.h>
#define F first
#define S second

using namespace std;
typedef pair<int,int> pii;

int M,N;
int board[501][501];
int dp[501][501];
int dy[4]={0,0,1,-1};
int dx[4]={1,-1,0,0};

struct comp
{
	bool operator()(pii a, pii b)
	{
		return board[a.F][a.S]<board[b.F][b.S];
	}
};

priority_queue<pii, vector<pii>, comp> PQ;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>M>>N;
	for(int i=1;i<=M;i++)
	{
		for(int j=1;j<=N;j++)
		{
			cin>>board[i][j];
			PQ.push({i,j});
		}
	}
	dp[1][1]=1;
	while(!PQ.empty())
	{
		int y=PQ.top().F,x=PQ.top().S;
		PQ.pop();
		for(int i=0;i<4;i++)
		{
			int ny=y+dy[i],nx=x+dx[i];
			if(board[ny][nx]>board[y][x])
				dp[y][x]+=dp[ny][nx];
		}
	}
	cout<<dp[M][N];
}