#include<bits/stdc++.h>
#define MAX 53

using namespace std;

int c[MAX][MAX];
int f[MAX][MAX];
int N;
vector<int> G[MAX];
int p[MAX];

int ctoi(char c)
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
		c[u][v]+=w;
		c[v][u]+=w;
		G[u].push_back(v);
		G[v].push_back(u);
	}
	int ans=0;
	while(1)
	{
		queue<int> Q;
		memset(p,0,sizeof(p));
		Q.push(1);
		while(!Q.empty()&&!p[26])
		{
			int u=Q.front();
			Q.pop();
			for(int v:G[u])
			{
				if(c[u][v]-f[u][v]>0&&!p[v])
				{
					p[v]=u;
					Q.push(v);
				}
			}
		}
		if(!p[26])
			break;
		int flow=INT_MAX;
		for(int i=26;i!=1;i=p[i])
			flow=min(flow,c[p[i]][i]-f[p[i]][i]);
		for(int i=26;i!=1;i=p[i])
		{
			f[p[i]][i]+=flow;
			f[i][p[i]]-=flow;
		}
		ans+=flow;
	}
	cout<<ans;
}