#include<bits/stdc++.h>

using namespace std;

vector<int> G[1001];
bool visited[1001];
int match[1001];
int N,M,K;

bool dfs(int x)
{
	if(visited[x])
		return false;
	visited[x]=true;
	for(int adj:G[x])
	{
		if(!match[adj]||dfs(match[adj]))
		{
			match[adj]=x;
			return true;
		}
	}
	return false;
}

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>N>>M>>K;
	for(int i=1;i<=N;i++)
	{
		int n;
		cin>>n;
		for(int j=0;j<n;j++)
		{
			int a;
			cin>>a;
			G[i].push_back(a);
		}
	}
	int ans=0,cnt=0;
	for(int i=1;i<=N;i++)
	{
		memset(visited,false,sizeof(visited));
		if(dfs(i))
			ans++;
	}
	for(int i=1;i<=N&&cnt<K;i++)
	{
		memset(visited,false,sizeof(visited));
		if(dfs(i))
		{
			ans++;
			cnt++;
		}
	}
	cout<<ans;
}