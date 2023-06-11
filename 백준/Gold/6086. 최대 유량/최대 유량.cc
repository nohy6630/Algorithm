#include<bits/stdc++.h>

using namespace std;

int c[53][53];
int f[53][53];
int N;
vector<int> G[53];

int edmonskarp(int s,int t)
{
	int ret=0;
	while(1)
	{
		int p[53];
		queue<int> Q;
		memset(p,0,sizeof(p));
		p[s]=s;
		Q.push(s);
		while(!Q.empty()&&!p[t])//bfs 순회하면서 parent배열 세팅 
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
		if(!p[t])//현재 flow network에서는 d에 도달하지 못하므로 break 
			break;
		int flow = INT_MAX;
		for(int i=t;i!=s;i=p[i])
			flow=min(flow,c[p[i]][i]-f[p[i]][i]);//순회한 bfs경로를 탐색하면서 흘릴수있는 최대 flow찾음 
		for(int i=t;i!=s;i=p[i])
		{
			f[p[i]][i]+=flow; 
			f[i][p[i]]-=flow;
		}
		ret+=flow;
	}
	return ret;
}

int ctoi(char c)
{
	if(isupper(c))
		return c-'A'+1;
	else
		return c-'a'+27;
}

int main()
{
	ios_base::sync_with_stdio(0);cin.tie(0);
	cin>>N;
	for(int i=0;i<N;i++)
	{
		char u, v;
		int w;
		cin>>u>>v>>w;
		u=ctoi(u);
		v=ctoi(v);
		G[u].push_back(v);
		G[v].push_back(u);
		c[u][v]+=w; 
		c[v][u]+=w;
	}
	cout<<edmonskarp(1,26);
}