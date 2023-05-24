/*
벨만포드 문제의 경우에는 사이클이 존재한다면 사이클에의해 cost or dist값이 계속 누적되어 계산되므로 간선의 가중치 범위가 적더라도 int 범위를 벗어날수 있음.
따라서 벨만포드 문제에선 최대한 long long을 쓰는게 좋은듯
*/

#include "bits/stdc++.h"
#define X first
#define Y second

using namespace std;

typedef pair<long long, int> pii;

int N, M;
vector<pii> G[501];
long long dist[501];

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int A, B, C;
        cin >> A >> B >> C;
        G[A].push_back({C, B});
    }
    fill(dist + 1, dist + 1 + N, LLONG_MAX);
    dist[1] = 0;
    for (int k = 0; k < N; k++)
    {
        for (int i = 1; i <= N; i++)
        {
            for (auto adj : G[i])
            {
                long long w = adj.X;
                int v = adj.Y;
                if (dist[i] != LLONG_MAX && dist[i] + w < dist[v])
                {
                    if (k == N - 1)
                    {
                        cout << -1;
                        return 0;
                    }
                    dist[v] = dist[i] + w;
                }
            }
        }
    }
    for (int i = 2; i <= N; i++)
    {
        if (dist[i] == LLONG_MAX)
            cout << -1 << '\n';
        else
            cout << dist[i] << '\n';
    }
}