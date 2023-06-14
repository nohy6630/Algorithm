/*
scc를 구하는 kosaraju알고리즘의 시간복잡도는 O(V+E)이다. 
*/
#include<bits/stdc++.h>

using namespace std;

int V,E,ans;
vector<int> G[10001];
vector<int> RG[10001];
vector<int> S;
bool visited[10001];
vector<vector<int>> paths;

void dfs(int x)
{
	if(visited[x])
		return;
	visited[x]=true;
	for(int adj:G[x])
		dfs(adj);
	S.push_back(x);
}

void dfs2(int x,vector<int>& path)
{
	if(visited[x])
		return;
	path.push_back(x);
	visited[x]=true;
	for(int adj:RG[x])
		dfs2(adj,path);
}

bool cmp(vector<int> a, vector<int> b)
{
	return a[0]<b[0];
}

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>V>>E;
	for(int i=0;i<E;i++)
	{
		int a,b;
		cin>>a>>b;
		G[a].push_back(b);
		RG[b].push_back(a);
	}
	for(int i=1;i<=V;i++)
		dfs(i);
	memset(visited,false,sizeof(visited));
	while(!S.empty())
	{
		int cur=S.back();
		S.pop_back();
		if(!visited[cur])
		{
			ans++;
			vector<int> path;
			dfs2(cur,path);
			sort(path.begin(),path.end());
			paths.push_back(path);
		}
	}
	cout<<ans<<'\n';
	sort(paths.begin(),paths.end(),cmp);
	for(int i=0;i<paths.size();i++)
	{
		for(int n:paths[i])
			cout<<n<<' ';
		cout<<-1<<'\n';
	}
}