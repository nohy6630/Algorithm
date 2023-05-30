/*
집합을브루트포스로만든다하면2^26의시간복잡도이고이거는10^6~7이므로1초가안넘기때메가능
*/

#include "bits/stdc++.h"

using namespace std;

int N, K;
vector<string> words;
int ans = 0;
int X;
int Y[50];

int getCnt()
{
    int cnt = 0;
    for (int i = 0; i < N; i++)
    {
        if ((Y[i] & X) == Y[i])
            cnt++;
    }
    return cnt;
}

void dfs(int idx,int k)
{
    if (idx == 26||k==K)
    {
        // for(int i=0;i<26;i++)
        // {
        //     if(X&(1<<i))
        //         cout<<(char)('a'+i)<<" ";
        // }
        // cout<<'\n';
        ans = max(ans, getCnt());
        return;
    }
    if (X & (1 << idx))
        dfs(idx + 1,k);
    else
    {
        X ^= (1 << idx);
        dfs(idx + 1,k+1);
        X ^= (1 << idx);
        dfs(idx + 1,k);
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N >> K;
    for (int i = 0; i < N; i++)
    {
        string s;
        cin >> s;
        words.push_back(s);
        for (int j = 0; j < s.size(); j++)
            Y[i] |= (1 << (s[j] - 'a'));
    }
    X |= (1 << ('a' - 'a')); // 0
    X |= (1 << ('n' - 'a')); // 13
    X |= (1 << ('t' - 'a')); // 19
    X |= (1 << ('i' - 'a')); // 8
    X |= (1 << ('c' - 'a')); // 2
    if (K < 5)
    {
        cout << 0;
        return 0;
    }
    dfs(0,5);
    cout << ans;
}