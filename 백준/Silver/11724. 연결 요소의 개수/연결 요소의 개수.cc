#include<bits/stdc++.h>

using namespace std;

int N,M;
vector<int> G[1001];
bool visited[1001];

void dfs(int n)
{
	visited[n]=true;
	for(int next:G[n])
	{
		if(!visited[next])
			dfs(next);
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	for(int i=0;i<M;i++)
	{
		int u,v;
		cin>>u>>v;
		G[u].push_back(v);
		G[v].push_back(u);
	}
	int ans=0;
	for(int i=1;i<=N;i++)
	{
		if(!visited[i])
		{
			ans++;
			dfs(i);
		}
	}
	cout<<ans;
}