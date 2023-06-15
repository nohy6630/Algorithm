#include<bits/stdc++.h>

using namespace std;

int N;
int c[53][53];
int f[53][53];
vector<int> G[53];
int p[53];
int ans;

char ctoi(char c)
{
	if(isupper(c))
		return c-'A'+1;
	return c-'a'+27;
}

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>N;
	for(int i=0;i<N;i++)
	{
		char u,v;
		int w;
		cin>>u>>v>>w;
		u=ctoi(u);
		v=ctoi(v);
		G[u].push_back(v);
		G[v].push_back(u);
		c[u][v]+=w;
		c[v][u]+=w;
	}
	while(1)
	{
		memset(p,false,sizeof(p));
		queue<int> Q;
		Q.push(1);
		p[1]=1;
		while(!Q.empty()&&!p[26])
		{
			int u=Q.front();
			Q.pop();
			for(int v:G[u])
			{
				if(!p[v]&&c[u][v]-f[u][v]>0)
				{
					Q.push(v);
					p[v]=u;
				}
			}
		}
		if(!p[26])
			break;
		int flow=INT_MAX;
		for(int i=26;i!=1;i=p[i])
		{
			flow=min(flow,c[p[i]][i]-f[p[i]][i]);
		}
		for(int i=26;i!=1;i=p[i])
		{
			f[p[i]][i]+=flow;
			f[i][p[i]]-=flow;
		}
		ans+=flow;
	}
	cout<<ans;
}