#include<bits/stdc++.h>

using namespace std;

vector<int> G[101];
int N,M;
int cnt;
bool visited[101];

void dfs(int n)
{
	cnt++;
	visited[n]=true;
	for(int adj:G[n])
	{
		if(visited[adj])
			continue;
		dfs(adj);
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	for(int i=1;i<=M;i++)
	{
		int a,b;
		cin>>a>>b;
		G[a].push_back(b);
		G[b].push_back(a);
	}
	dfs(1);
	cout<<cnt-1;
}