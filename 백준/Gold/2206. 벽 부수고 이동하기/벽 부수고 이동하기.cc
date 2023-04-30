/*
bfs 문제이다. 그리고 큐에 저장해야되는게 좌표뿐 아니라 벽을 부섰는지 유무도 저장해야한다. 
visited도 벽을 부섰을때와 안부섰을때를 구분해야한다. 벽을 부서서 먼저 도달한경우에 visited를 체크해버리면 벽을 안부시고 돌아서 온경우에 방문을 하지 못하게 된다. 
dist도 마찬가지로 구분해줘야 한다. 
*/
#include<bits/stdc++.h>
#define MAX 1000

using namespace std;

struct Node{
	int x,y;
	bool breaked;
};

int N,M;
bool board[MAX+1][MAX+1];
bool visited[MAX+1][MAX+1][2];
int dist[MAX+1][MAX+1][2];

int dy[4]={0,-1,0,1};
int dx[4]={-1,0,1,0};

void bfs()
{
	queue<Node> Q;
	Q.push({1,1,0});
	visited[1][1][0]=true;
	dist[1][1][0]=1;
	while(!Q.empty())
	{
		Node n=Q.front();
		//cout<<"node pop {"<<n.x<<", "<<n.y<<", "<<n.breaked<<"}\n";
		Q.pop();
		for(int i=0;i<4;i++)
		{
			int x=n.x+dx[i],y=n.y+dy[i];
			if(y<1||x<1||y>N||x>M)
				continue;
			if(visited[y][x][n.breaked])
				continue;
			if(!board[y][x]||!n.breaked)
			{
				Q.push({x,y,board[y][x]||n.breaked});
				visited[y][x][board[y][x]||n.breaked]=true;
				dist[y][x][board[y][x]||n.breaked]=dist[n.y][n.x][n.breaked]+1;
			}
		}
		//cout<<dist[n.y][n.x][n.breaked]<<"\n";
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	cin.ignore();
	for(int i=1;i<=N;i++)
	{
		string s;
		getline(cin,s);
		for(int j=1;j<=s.size();j++)
			board[i][j]=s[j-1]=='1';
	}
	memset(dist,-1,sizeof(dist));
	bfs();
	if(dist[N][M][0]==-1&&dist[N][M][1]==-1)
		cout<<"-1";
	else
	{
		if(dist[N][M][0]==-1)
			dist[N][M][0]=INT_MAX;
		if(dist[N][M][1]==-1)
			dist[N][M][1]=INT_MAX;
		cout<<min(dist[N][M][1],dist[N][M][0]);
	}
} 