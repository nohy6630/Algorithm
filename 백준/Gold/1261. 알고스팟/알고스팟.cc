#include<bits/stdc++.h>
#define Y first
#define X second

using namespace std;
typedef pair<int,int> pii;
typedef pair<int,pii> pip;

int N,M;
int board[101][101];
int d[101][101];
priority_queue<pip,vector<pip>,greater<pip>> PQ;
int dy[]={-1,1,0,0};
int dx[]={0,0,-1,1};

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>N>>M;
	cin.ignore();
	for(int i=1;i<=M;i++)
	{
		string s;
		getline(cin,s);
		for(int j=1;j<=s.size();j++)
		{
			board[i][j]=s[j-1]-'0';
		}
	}
	for(int i=0;i<=100;i++)
	{
		for(int j=0;j<=100;j++)
			d[i][j]=INT_MAX;
	}
	d[1][1]=0;
	PQ.push({d[1][1],{1,1}});
	while(!PQ.empty())
	{
		int t = PQ.top().first;
		pii u = PQ.top().second;
		PQ.pop();
		if(t>d[u.Y][u.X])
			continue;
		for(int i=0;i<4;i++)
		{
			int nx=u.X+dx[i],ny=u.Y+dy[i];
			if(nx<1||nx>N||ny<1||ny>M)
				continue;
			if(d[u.Y][u.X]+board[ny][nx]<d[ny][nx])
			{
				d[ny][nx]=d[u.Y][u.X]+board[ny][nx];
				PQ.push({d[ny][nx],{ny,nx}});
			}
		}
	}
	cout<<d[M][N];
}