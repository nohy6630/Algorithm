/*
벨만포드는 사이클이 존재할수 있으니 항상 long long을쓰자. 
*/

#include<bits/stdc++.h>

using namespace std;
typedef pair<int,int> pii;

int N,M;
int start,e;
vector<pii> G[51];
int profit[51];
long long d[51];
bool visited[51];

bool dfs(int x)
{
	bool ret=false;
	if(x==e)
		return true;
	if(visited[x])
		return false;
	visited[x]=true;
	for(pii adj:G[x])
	{
		ret|=dfs(adj.second);
	}
	return ret;
}

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>N>>start>>e>>M;
	for(int i=0;i<M;i++)
	{
		int u,v,w;
		cin>>u>>v>>w;
		G[u].push_back({-w,v});
	}
	
	for(int i=0;i<N;i++)
		cin>>profit[i];
	for(int i=0;i<N;i++)
	{
		for(pii& adj:G[i])
		{
			adj.first+=profit[adj.second];
		}
	}
	
	for(int u=0;u<N;u++)
		{
			for(pii adj:G[u])
			{
				int w=adj.first,v=adj.second;
				//cout<<"G["<<u<<"] contain "<<w<<" "<<v<<'\n';
			}
		}
	
	fill(d,d+N,LLONG_MIN);
	d[start]=profit[start];
	for(int i=0;i<N-1;i++)
	{
		for(int u=0;u<N;u++)
		{
			if(d[u]==LLONG_MIN)
				continue;
			for(pii adj:G[u])
			{
				int w=adj.first,v=adj.second;
				if(d[u]+w>d[v])
				{
					//cout<<"d["<<v<<"]=d["<<u<<"] + "<<w<<'\n';
					d[v]=d[u]+w;
				}
			}
		}
	}
	if(d[e]==LLONG_MIN)
		cout<<"gg";
	else
	{
		for(int u=0;u<N;u++)
		{
			if(d[u]==LLONG_MIN)
				continue;
			for(pii adj:G[u])
			{
				int w=adj.first,v=adj.second;
				if(d[u]+w>d[v]&&dfs(u))
				{
					cout<<"Gee";
					return 0;
				}
			}
		}
		cout<<d[e];
	}
}