/*
1. MST를 인접리스트 형태로 만든다.
2. 공장 출발 노드부터 dfs 또는 bfs로 순회를 하면서 공장 도착 노드까지 도달할때까지의 최대중량을 maxWeight[노드수]에 저장
3. maxWeight[공장 도착 노드]를 출력 
*/

#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> pii;

struct Edge
{
	int u,v,w;
};

int parent[100001];
vector<pii> G[100001];
int maxWeight[100001];
bool visited[100001];
vector<Edge> edges;
int N,M;
int fac[2];

int find(int x)
{
	if(parent[x]==x)
		return x;
	else
		return find(parent[x]);
}

void unionSet(int a, int b)
{
	a=find(a);
	b=find(b);
	parent[b]=a;
}

void dfs(int n,int weight)
{
	visited[n]=true;
	maxWeight[n]=weight;
	for(pii adj:G[n])
	{
		if(visited[adj.first])
			continue;
		dfs(adj.first,min(weight,adj.second));
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	for(int i=1;i<=M;i++)
	{
		int a,b,c;
		cin>>a>>b>>c;
		edges.push_back({a,b,c});
	}
	cin>>fac[0]>>fac[1];
	sort(edges.begin(),edges.end(),[](Edge a, Edge b){
		return a.w>b.w;
	});
	for(int i=1;i<=N;i++)
		parent[i]=i;
	for(int i=1;i<=edges.size();i++)
	{
		int u=edges[i-1].u,v=edges[i-1].v,w=edges[i-1].w;
		if(find(u)!=find(v))
		{
			unionSet(u,v);
			G[u].push_back({v,w});
			G[v].push_back({u,w});
		}
	}
	dfs(fac[0],INT_MAX);
	cout<<maxWeight[fac[1]];
}