#include<bits/stdc++.h>

using namespace std;

vector<int> G[100001];
int N;
bool visited[100001];
int parent[100001];

void dfs(int n)
{
	visited[n]=true;
	for(int adj:G[n])
	{
		if(visited[adj])
			continue;
		parent[adj]=n;
		dfs(adj);
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=1;i<N;i++)
	{
		int a,b;
		cin>>a>>b;
		G[a].push_back(b);
		G[b].push_back(a);
	}
	dfs(1);
	for(int i=2;i<=N;i++)
		cout<<parent[i]<<'\n';
}