/*
priority queue에 도로포장 정보도 넣어야함.
그리고 다익스트라에서 dist배열을 비교할때 해당 도로를 포장할지 안할지 두 경우에 대해서 dist[i][j]와 dist[i][j+1]을 채워야함.  
*/
#include<bits/stdc++.h>
#define X first
#define Y second

using namespace std;

typedef pair<int,int> pii;
typedef pair<int,pii> piii; 

int N,M,K;
long long dist[10001][21];
vector<pii> G[10001];

void dijkstra()
{
	for(int i=0;i<=10000;i++)
	{
		for(int j=0;j<=20;j++)
			dist[i][j]=LLONG_MAX;
	}
	priority_queue<piii,vector<piii>,greater<piii>> PQ;
	PQ.push({0,{1,0}});
	dist[1][0]=0;
	while(!PQ.empty())
	{ 
		int u=PQ.top().Y.X;
		int cnt=PQ.top().Y.Y;
		int tmp=PQ.top().X;
		PQ.pop();
		if(tmp>dist[u][cnt])//큐에들어가기 전에는 조건이 맞았지만 큐에 나왔을때에는 조건이 틀린경우를 예외처리 해야됨. 안그럼 시간초과 
			continue;
		for(pii adj:G[u])
		{
			int w=adj.X;int v=adj.Y;
			if(dist[u][cnt]+w<dist[v][cnt])
			{
				dist[v][cnt]=dist[u][cnt]+w;
				PQ.push({dist[v][cnt],{v,cnt}});
			}
			if(cnt<K&&dist[u][cnt]<dist[v][cnt+1])
			{
				dist[v][cnt+1]=dist[u][cnt];
				PQ.push({dist[v][cnt+1],{v,cnt+1}});
			}
		}
	}	
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M>>K;
	for(int i=0;i<M;i++)
	{
		int u,v,w;
		cin>>u>>v>>w;
		G[u].push_back({w,v});
		G[v].push_back({w,u});
	}
	dijkstra();
	cout<<*min_element(dist[N], dist[N]+K+1)<<'\n';
}