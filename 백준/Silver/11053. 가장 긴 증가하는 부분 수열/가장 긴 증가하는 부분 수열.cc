#include "bits/stdc++.h"

using namespace std;

int N;
int A[1002];
int lis[1002];
int dp[1002];

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for (int i = 1; i <= N; i++)
        cin >> A[i];
    dp[1] = 1;
    lis[1] = A[1];
    for (int i = 2; i <= N; i++)
    {
        int idx = lower_bound(lis + 1, lis + 1 + dp[i - 1], A[i]) - lis;
        lis[idx] = A[i];
        if (idx == dp[i - 1] + 1)
            dp[i] = dp[i - 1] + 1;
        else
            dp[i] = dp[i - 1];
    }
    cout << dp[N];
}