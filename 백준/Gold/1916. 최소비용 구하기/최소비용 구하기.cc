#include "bits/stdc++.h"
#define X first
#define Y second

using namespace std;

typedef pair<int, int> pii;

vector<pii> G[1001];
int dist[1001];
int N, M;
priority_queue<pii, vector<pii>, greater<pii>> PQ;
int S, E;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int u, v, w;
        cin >> u >> v >> w;
        G[u].push_back({w, v});
    }
    cin >> S >> E;
    fill(dist + 1, dist + 1 + N, INT_MAX);
    dist[S] = 0;
    PQ.push({0, S});
    while (!PQ.empty())
    {
        int tmp = PQ.top().X, u = PQ.top().Y;
        PQ.pop();
        if (tmp > dist[u])
            continue;
        for (auto adj : G[u])
        {
            int w = adj.X, v = adj.Y;
            if (dist[u] + w < dist[v])
            {
                dist[v] = dist[u] + w;
                PQ.push({dist[v], v});
            }
        }
    }
    cout << dist[E];
}