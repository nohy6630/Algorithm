#include<bits/stdc++.h>

using namespace std;

int N,P;
int f[401][401];
int c[401][401];
vector<int> G[401];
int ans;
int p[401];

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>N>>P;
	for(int i=0;i<P;i++)
	{
		int a,b;
		cin>>a>>b;
		G[a].push_back(b);
		G[b].push_back(a);
		c[a][b]=1;
	}
	while(1)
	{
		queue<int> Q;
		memset(p,0,sizeof(p));
		p[1]=1;
		Q.push(1);
		while(!Q.empty()&&!p[2])
		{
			int u=Q.front();
			Q.pop();
			for(int v:G[u])
			{
				if(!p[v]&&c[u][v]-f[u][v]>0)
				{
					p[v]=u;
					Q.push(v);
				}
			}
		}
		if(!p[2])
			break;
		int flow=INT_MAX;
		for(int i=2;i!=1;i=p[i])
			flow=min(flow,c[p[i]][i]-f[p[i]][i]);
		for(int i=2;i!=1;i=p[i])
		{
			f[p[i]][i]+=flow;
			f[i][p[i]]-=flow;
		}
		ans+=flow;
	}
	cout<<ans;
}