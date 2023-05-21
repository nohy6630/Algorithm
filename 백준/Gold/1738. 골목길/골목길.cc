#include<bits/stdc++.h>
#define X first
#define Y second

using namespace std;

typedef pair<int,int> pii;

int N,M;
vector<pii> G[101];
vector<int> revG[101];
long long dist[101];
int trace[101];
bool visited[101];
bool fail;
vector<int> S;

void bellmanford()
{
	fill(dist,dist+N+1,LLONG_MIN);
	dist[1]=0;
	for(int i=1;i<=N;i++)
	{
		for(int u=1;u<=N;u++)
		{
			if(dist[u]==LLONG_MIN)
				continue;
			for(auto adj:G[u])
			{
				int w=adj.X,v=adj.Y;
				if(dist[u]+w>dist[v])
				{
					dist[v]=dist[u]+w;
					trace[v]=u;
					if(i==N&&visited[v])
						fail=true;
				}
			}
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	for(int i=0;i<M;i++)
	{
		int u,v,w;
		cin>>u>>v>>w;
		G[u].push_back({w,v});
		revG[v].push_back(u);
	}
	queue<int> Q;
	Q.push(N);
	visited[N] = true;
	while (!Q.empty()) {
		int cidx = Q.front();
		Q.pop();
		for (int i = 0; i < revG[cidx].size(); i++) {
			int next = revG[cidx][i];
			if (!visited[next]) {
				visited[next] = true;
				Q.push(next);
			}
		}
	}
	bellmanford();
	if(fail)
		cout<<"-1";
	else
	{
		int n=N;
		while(n!=1)
		{
			S.push_back(n);
			n=trace[n];
		}
		S.push_back(1);
		while(!S.empty())
		{
			cout<<S.back()<<" ";
			S.pop_back();
		}
	}
}