#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <climits>
#define MAX 100

using namespace std;

struct fri_info
{
    int fri;
    int depth;
};
int N, M;
vector<int> G[MAX + 1];
int min_val = INT_MAX;
int min_idx;
bool visited[MAX + 1];

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> N >> M;
    for (int i = 0; i < M; i++)
    {
        int a, b;
        cin >> a >> b;
        G[a].push_back(b);
        G[b].push_back(a);
    }
    for (int i = 1; i <= N; i++)
    {
        queue<fri_info> Q;
        int val = 0;
        int depth = 0;
        Q.push({i, 0});
        visited[i] = true;
        while (!Q.empty())
        {
            fri_info info = Q.front();
            Q.pop();
            val += info.depth;
            for (auto f : G[info.fri])
            {
                if (visited[f])
                    continue;
                Q.push({f, info.depth + 1});
                visited[f] = true;
            }
        }
        if (val < min_val)
        {
            min_idx = i;
            min_val=val;
        }
        memset(visited, 0, sizeof(visited));
    }
    cout << min_idx << '\n';
    return 0;
}