/*
우선 그래프를 우리가 일반적으로 구현할때 이차원배열로 만든다 이때 이차원배열의 원소 타입을 보통 int로 주는데
다익스트라 알고리즘을 이용한다는것은 가중치가 있는 그래프라는 거다.
따라서 우리는 연결된 노드 뿐 아니라 거리의 가중치까지 같이 저장을 해야되므로
vector< vector< pair<int, int> > > 또는 vector < pair<int, int> > [N] 같은 타임으로 그래프를 저장해야한다.

그리고 시작점으로 부터 다른 모든 노드의 최단거리를 구하는 것이 다익스트라 알고리즘이므로 이를위해
최단거리를 저장할 1차원 배열 dist가 필요하다.
또한 우리는 {가중치, 노}를 저장할 최소힙을 선언한뒤 거기서 하나씩 pop해서 로직을 돌릴것이다.
그러므로 priority_queue로 최소힙을 구현

이후에는 pq에서 하나씩 pop하고 그 pop한 원소를 거쳐서 도착하는 정점들과의 거리와 dist배열을 비교하여 dist배열을 갱신해준다.
갱신되는 경우에는 pq에 새로운 {가중치, 노드}를push해준다.

방향그래프이기때문에 입력당 한 방향만  push해준다.
무방향이라면 양쪽 다 push 
*/
#include<bits/stdc++.h>

using namespace std;
typedef pair<int,int> pii;

int V, E, K;
vector<pii> G[20001];
priority_queue<pii, vector<pii>, greater<pii>> pq;
int dist[20001];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>V>>E>>K;
	for(int i=0;i<E;i++)
	{
		int u,v,w;
		cin>>u>>v>>w;
		G[u].push_back({w,v});
	}
	for(int i=1;i<=V;i++)
		dist[i]=INT_MAX;
	dist[K]=0;
	pq.push({0, K});
	while(!pq.empty())
	{
		int w=pq.top().first;
		int v=pq.top().second;
		pq.pop();
		for(auto p : G[v])
		{
			if(w+p.first<dist[p.second])
			{
				dist[p.second]=w+p.first;
				pq.push({dist[p.second], p.second});
			}
		}
	}
	for(int i=1;i<=V;i++)
	{
		if(dist[i]==INT_MAX)
			cout<<"INF\n";
		else
			cout<<dist[i]<<'\n';
	}
}