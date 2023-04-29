/*
벨만포드 알고리즘은 다익스트라 알고리즘 보다 느리지만 음의 간선이 포함된 경우에도 최단 거리를 구할 수 있고,
또한 음의 사이클의 존재 유무를 탐지할 수 있다. 
벨만포드 알고리즘은 다익스트라 알고리즘과 유사하지만 다음과 같은 차이점이 있다.
다익스트라알고리즘에서는 방문하지 않은 노드와 방문한 노드와 연결된 간선들만 조사하여 최단거리를 매번 갱신하지만,
벨만포드 알고리즘의 경우 매번 모든 간선을 조사하여 최단거리를 갱신한다.
N-1번 반복하여 모든 간선을 조사한다. 이때 음의 사이클의 여부를 검사하려면 
다시 한번 N-1번 반복하여 모든 간선을 조사하여 갱신되는 최단거리가 있다면 음의 사이클이 존재한다는 것이다. 

이 문제에는 출발지점이 정의되어 있지 않으므로 시간복잡도는 O(V) * O(VE)이므로 500*500*2500=625000000 6억? 
아니다. 우리에게 출발지점이 어디인지는 중요하지 않다. 어차피 그래프는 모두 연결되있고 우리는 음의사이클의 여부만 판단하면 되기때문에
출발지점은 임의로 정해도됨. 그러므로 시간복잡도는 그냥 단순 벨만포드 알고리즘인 O(VE)가 됨. 
*/

#include<bits/stdc++.h>
#define INF 25000000

using namespace std;

struct Edge
{
	int to,cost;	
};

vector<Edge> G[501];
int dist[501];
int T,N,M,W;

bool bellmanford()
{
	fill(dist+1,dist+1+N,INF);
	dist[1]=0;
	for(int i=0;i<N-1;i++)
	{
		for(int j=1;j<=N;j++)
		{
			for(auto e:G[j])
			{
					dist[e.to]=min(dist[e.to], dist[j]+e.cost);
			}
		}
	}
	for(int j=1;j<=N;j++)
	{
		for(auto e:G[j])
		{
//				단절된 부분그래프의 케이스에서도 음수사이클의 유무를 판단해야 되기 때문에 INF라고 스킵하면 안됨. 
				if(dist[e.to]>dist[j]+e.cost)
					return true;
		}
	}
	return false;
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>T;
	for(int i=0;i<T;i++)
	{
		cin>>N>>M>>W;
		for(int j=1;j<=N;j++)
			G[j].clear();
		for(int j=0;j<M;j++)
		{
			int a,b,c;
			cin>>a>>b>>c;
			G[a].push_back({b,c});
			G[b].push_back({a,c});
		}
		for(int j=0;j<W;j++)
		{
			int a,b,c;
			cin>>a>>b>>c;
			G[a].push_back({b,-c});
		}
		cout<<(bellmanford()?"YES":"NO")<<'\n';
	}
} 