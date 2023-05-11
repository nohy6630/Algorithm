#include "bits/stdc++.h"

using namespace std;

int N;
int pos[16];
int cnt;

void dfs(int y, int v)
{
    for (int i = 1; i < y; i++)
    {
        if (pos[i] == v || abs(y - i) == abs(v - pos[i]))
            return;
    }
    pos[y] = v;
    if (y == N)
        cnt++;
    else
    {
        for (int i = 1; i <= N; i++)
            dfs(y + 1, i);
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    for (int i = 1; i <= N; i++)
        dfs(1, i);
    cout << cnt;
}