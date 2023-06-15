#include<bits/stdc++.h>

using namespace std;
typedef pair<int,int> pii;

int V,E;
vector<pair<int,pii>> edges;
int p[10001];
int cnt,ans;

int Find(int x)
{
	if(p[x]==x)
		return x;
	return p[x]=Find(p[x]);
}

bool Union(int x,int y)
{
	int py=Find(y),px=Find(x);
	p[Find(y)]=Find(x);
	return py!=px;
}

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>V>>E;
	for(int i=0;i<E;i++)
	{
		int u,v,w;
		cin>>u>>v>>w;
		edges.push_back({w,{u,v}});
	}
	sort(edges.begin(),edges.end());
	for(int i=1;i<=V;i++)
		p[i]=i;
	for(auto e:edges)
	{
		int u=e.second.first,v=e.second.second;
		if(Union(u,v))
		{
			cnt++;
			ans+=e.first;
		}
		if(cnt>=V-1)
			break;
	}
	cout<<ans;
}