#include "bits/stdc++.h"

using namespace std;

int T,N,K,W;
int t[1001];
vector<int> G[1001];
vector<int> RG[1001];
vector<int> S;
bool visited[1001];
int dp[1001];

void dfs(int x)
{
    if(visited[x])
        return;
    visited[x]=true;
    for(auto adj:G[x])
        dfs(adj);
    S.push_back(x);
}

void solve()
{
    cin>>N>>K;
    for(int i=1;i<=N;i++)
        cin>>t[i];
    for(int i=1;i<=K;i++)
    {
        int a,b;
        cin>>a>>b;
        G[a].push_back(b);
        RG[b].push_back(a);
    }
    cin>>W;
    for(int i=1;i<=N;i++)
        dfs(i);
    while(!S.empty())
    {
        int cur = S.back();
        S.pop_back();
        dp[cur]=t[cur];
        for(auto adj:RG[cur])
            dp[cur]=max(dp[cur],dp[adj]+t[cur]);
    }
    cout<<dp[W]<<'\n';
    for(int i=1;i<=N;i++)
    {
        G[i].clear();
        RG[i].clear();
    }
    memset(dp,0,sizeof(dp));
    memset(t,0,sizeof(t));
    memset(visited,false,sizeof(visited));
}

int main()
{
    ios_base::sync_with_stdio(0);cin.tie(0);
    cin>>T;
    for(int i=0;i<T;i++)
    {
        solve();
    }
}