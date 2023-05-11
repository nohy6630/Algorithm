#include "bits/stdc++.h"

using namespace std;

int N, E;
int dist[101][101];

void floyd()
{
    for (int k = 1; k <= N; k++)
    {
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N; j++)
            {
                if (dist[i][k] != INT_MAX && dist[k][j] != INT_MAX)
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j]);
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> E;
    fill(&dist[0][0], &dist[0][0] + 101 * 101, INT_MAX);
    for (int i = 1; i <= N; i++)
        dist[i][i] = 0;
    for (int i = 0; i < E; i++)
    {
        int a, b, c;
        cin >> a >> b >> c;
        dist[a][b] = min(dist[a][b], c);
    }
    floyd();
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            if (dist[i][j] == INT_MAX)
                cout << "0 ";
            else
                cout << dist[i][j] << ' ';
        }
        cout << '\n';
    }
}