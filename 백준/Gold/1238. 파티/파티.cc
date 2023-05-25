#include "bits/stdc++.h"
#define X first
#define Y second

using namespace std;

typedef pair<int, int> pii;

int M, N, x;
vector<pii> G[1001];
int dist[1001];
int back_dist[1001];
int ans = INT_MIN;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M >> x;
    for (int i = 0; i < M; i++)
    {
        int u, v, w;
        cin >> u >> v >> w;
        G[u].push_back({w, v});
    }
    priority_queue<pii, vector<pii>, greater<pii>> PQ;
    fill(back_dist + 1, back_dist + 1 + N, INT_MAX);
    back_dist[x] = 0;
    PQ.push({0, x});
    while (!PQ.empty())
    {
        int tmp = PQ.top().X, u = PQ.top().Y;
        PQ.pop();
        if (back_dist[u] < tmp)
            continue;
        for (auto adj : G[u])
        {
            int w = adj.X, v = adj.Y;
            if (back_dist[u] + w < back_dist[v])
            {
                back_dist[v] = back_dist[u] + w;
                PQ.push({back_dist[v], v});
            }
        }
    }
    for (int i = 1; i <= N; i++)
    {
        priority_queue<pii, vector<pii>, greater<pii>> PQ;
        fill(dist + 1, dist + 1 + N, INT_MAX);
        dist[i] = 0;
        PQ.push({0, i});
        while (!PQ.empty())
        {
            int tmp = PQ.top().X, u = PQ.top().Y;
            PQ.pop();
            if (dist[u] < tmp)
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
        ans = max(ans, dist[x] + back_dist[i]);
    }
    cout << ans;
}