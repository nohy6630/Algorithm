#include <iostream>
#include <vector>

using namespace std;

int N,M;
int cnt;
vector<int> G[101];
bool visited[101];

void dfs(int n)
{
	visited[n]=true;
	for(auto com : G[n])
	{
		if(visited[com])
			continue;
		cnt++;
		dfs(com);
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	for(int i=0;i<M;i++)
	{
		int a,b;
		cin>>a>>b;
		G[a].push_back(b);
		G[b].push_back(a);
	}
	dfs(1);
	cout<<cnt;
	return 0;
}