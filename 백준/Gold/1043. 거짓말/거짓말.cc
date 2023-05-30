#include "bits/stdc++.h"

using namespace std;

int N, M;
int p[51];
vector<int> party[51];

int Find(int x)
{
    if (p[x] == x)
        return x;
    return p[x] = Find(p[x]);
}

void Union(int x, int y)
{
    p[Find(y)] = Find(x);
}

bool isContiainTrue(int i)
{
    for (int n : party[i])
    {
        if (Find(0) == Find(n))
            return true;
    }
    return false;
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> M;
    for (int i = 0; i <= N; i++)
        p[i] = i;
    int a;
    cin >> a;
    for (int i = 0; i < a; i++)
    {
        int b;
        cin >> b;
        Union(0, b);
    }
    for (int i = 1; i <= M; i++)
    {
        int num;
        cin >> num;
        for (int j = 0; j < num; j++)
        {
            int man;
            cin >> man;
            party[i].push_back(man);
        }
    }
    for (int k = 0; k < M; k++)
    {
        for (int i = 1; i <= M; i++)
        {
            if (isContiainTrue(i))
            {
                for (int n : party[i])
                    Union(0, n);
            }
        }
    }
    int ans = 0;
    for (int i = 1; i <= M; i++)
    {
        if (!isContiainTrue(i))
            ans++;
    }
    cout << ans;
}