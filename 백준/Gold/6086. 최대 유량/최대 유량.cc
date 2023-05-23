#include "bits/stdc++.h"
#define X first
#define Y second
#define MAX 53

using namespace std;

typedef pair<int, int> pii;

int capacity[MAX][MAX];
int flow[MAX][MAX];
int N;
vector<int> G[MAX];

int edmonskarp(int src, int dest)
{
    int maxflow = 0;
    while (1)
    {
        int parent[MAX];
        queue<int> Q;
        fill(parent, parent + MAX, 0);
        parent[src] = src;
        Q.push(src);
        while (!Q.empty() && !parent[dest])
        {
            int cur = Q.front();
            Q.pop();
            for (int i : G[cur])
            {
                if (capacity[cur][i] - flow[cur][i] > 0 && !parent[i])
                {
                    parent[i] = cur;
                    Q.push(i);
                }
            }
        }
        if (!parent[dest])
            break;
        int curflow = INT_MAX;
        for (int i = dest; i != src; i = parent[i])
            curflow = min(capacity[parent[i]][i] - flow[parent[i]][i], curflow);
        for (int i = dest; i != src; i = parent[i])
        {
            flow[parent[i]][i] += curflow;
            flow[i][parent[i]] -= curflow;
        }
        maxflow += curflow;
    }
    return maxflow;
}

int ctoi(char c)
{
    if (isupper(c))
        return c - 'A' + 1;
    else
        return c - 'a' + 27;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 0; i < N; i++)
    {
        char u, v;
        int w;
        cin >> u >> v >> w;
        u = ctoi(u);
        v = ctoi(v);
        capacity[u][v] += w;
        capacity[v][u] += w;
        G[u].push_back(v);
        G[v].push_back(u);
    }
    cout << edmonskarp(1, 26);
}