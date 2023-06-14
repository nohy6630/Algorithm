/*
이분매칭 알고리즘의 시간복잡도는 O(VE)이다. 
*/
#include<bits/stdc++.h>

using namespace std;

int N,M,ans;
bool visited[201];
int match[201];
vector<int> G[201];

bool dfs(int x)
{
	if(visited[x])
		return false;
	visited[x]=true;
	for(int adj:G[x])
	{
		if(!match[adj])
		{
			match[adj]=x;
			return true;
		}
	}
	for(int adj:G[x])
	{
		if(dfs(match[adj]))
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
	cin>>N>>M;
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
	for(int i=1;i<=N;i++)
	{
		memset(visited,false,sizeof(visited));
		if(dfs(i))
			ans++;
	}
	cout<<ans;
}