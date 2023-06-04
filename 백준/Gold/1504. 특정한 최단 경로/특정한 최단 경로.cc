#include<bits/stdc++.h>

using namespace std;
typedef pair<int,int> pii;

int N,E;
vector<pii> G[801];
int M[2];
int dist[801][801];
int ans=INT_MAX;

void dijkstra(int s)
{
	priority_queue<pii,vector<pii>,greater<pii>> PQ;
	dist[s][s]=0;
	PQ.push({dist[s][s],s});
	while(!PQ.empty())
	{
		int tmp=PQ.top().first,u=PQ.top().second;
		PQ.pop();
		if(tmp>dist[s][u])
			continue;
		for(auto adj:G[u])
		{
			int w=adj.first,v=adj.second;
			if(dist[s][u]+w<dist[s][v])
			{
				dist[s][v]=dist[s][u]+w;
				PQ.push({dist[s][v],v});
			}
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>E;
	for(int i=0;i<E;i++)
	{
		int a,b,c;
		cin>>a>>b>>c;
		G[a].push_back({c,b});
		G[b].push_back({c,a});
	}
	cin>>M[0]>>M[1];
	for(int i=0;i<801;i++)
	{
		for(int j=0;j<801;j++)
			dist[i][j]=INT_MAX;
	}
	dijkstra(1);
	dijkstra(M[0]);
	dijkstra(M[1]);
	if(dist[1][M[0]]!=INT_MAX&&dist[M[0]][M[1]]!=INT_MAX&&dist[M[1]][N]!=INT_MAX)
		ans=min(ans,dist[1][M[0]]+dist[M[0]][M[1]]+dist[M[1]][N]);
	if(dist[1][M[1]]!=INT_MAX&&dist[M[1]][M[0]]!=INT_MAX&&dist[M[0]][N]!=INT_MAX)
		ans=min(ans,dist[1][M[1]]+dist[M[1]][M[0]]+dist[M[0]][N]);
	if(ans==INT_MAX)
		cout<<-1;
	else
		cout<<ans;
}