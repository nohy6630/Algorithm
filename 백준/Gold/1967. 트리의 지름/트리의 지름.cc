/*
루트노드로부터 dfs를 돌려서 가장 먼 노드를 찾고 그 노드로 부터 다시 dfs노드를 돌려서 가장 먼 거리가 그 트리의 지름이된다.
트리라고 하지만 그냥 그래프처럼 구현하면 될것같다. 트리도 그래프의 일종이니까.
가중치가 있는 그래프면은 pair타입의 2차원배열을 이용해야되나? 그러네 ㅇㅇ
짜다보니 다익스트라의 하위호환버전 dfs가 됬다...
어차피 가중치가 있기 때문에 모든 자식들을 다 순회해야되네..
*/
#include <iostream>
#include <vector>
#include <utility>
#include <cstring>
#include <algorithm>
#include <climits>

#define MAX 10000

using namespace std;

typedef pair<int, int> pii;

int N;
vector<pii> G[MAX + 1];
int dist[MAX + 1];

void dfs(int n)
{
    for (auto adj : G[n])
    {
        if (dist[n] + adj.second < dist[adj.first])
        {
            dist[adj.first] = dist[n] + adj.second;
            dfs(adj.first);
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N - 1; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        G[a].push_back({b, c});
        G[b].push_back({a, c});
    }
    int dis = INT_MIN;
    int idx=1;
    for (int i = 1; i <= MAX; i++)
        dist[i] = INT_MAX;
    dist[1] = 0;
    dfs(1);
    for (int i = 1; i <= MAX; i++)
    {
        if (i == 1)
            continue;
        if (dist[i] != INT_MAX && dist[i] > dis)
        {
            dis = dist[i];
            idx = i;
        }
    }
    for (int i = 1; i <= MAX; i++)
        dist[i] = INT_MAX;
    dist[idx] = 0;
    dfs(idx);
    dis = INT_MIN;
    for (int i = 1; i <= MAX; i++)
    {
        if (i == idx)
            continue;
        if (dist[i] != INT_MAX && dist[i] > dis)
        {
            dis = dist[i];
            idx = i;
        }
    }
    if (N == 1)
        cout << 0;
    else
        cout << dis;
}