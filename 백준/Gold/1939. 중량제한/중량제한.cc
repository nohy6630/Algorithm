#include<bits/stdc++.h>
#define MAX 10001
#define X first
#define Y second

using namespace std;

typedef pair<int,int> pii;

int N,M;
vector<pii> G[MAX];
priority_queue<pii> pq;
int fac[2];
int weight[MAX];

void dijkstra()
{
	fill(weight,weight+MAX,INT_MIN);
	pq.push({INT_MAX,fac[0]});
	weight[fac[0]]=INT_MAX;
	while(!pq.empty())
	{
		pii cur=pq.top();
		//cout<<"cur={"<<cur.X<<","<<cur.Y<<"}\n";
		pq.pop();
		if(weight[cur.Y]>cur.X)
			continue;
		for(auto next:G[cur.Y])
		{
			if(min(next.X,cur.X)>weight[next.Y])
			{
				weight[next.Y]=min(next.X,cur.X);
				pq.push({weight[next.Y],next.Y});
			}
		}
	}
} 

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	for(int i=1;i<=M;i++)
	{
		int a,b,c;
		cin>>a>>b>>c;
		G[a].push_back({c,b});
		G[b].push_back({c,a});
	}
	cin>>fac[0]>>fac[1];
	dijkstra();
	cout<<weight[fac[1]];
}
