#include <bits/stdc++.h>

using namespace std;

int N;
int dp[5001];

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cin >> N;
    fill(dp,dp+N+1,-1);
    dp[3] = 1;
    dp[5] = 1;
    for (int i = 6; i <= N; i++)
    {
    	int a=dp[i-3]!=-1?dp[i-3]+1:INT_MAX;
    	int b=dp[i-5]!=-1?dp[i-5]+1:INT_MAX;
        dp[i] = min(a, b);
        if(dp[i]==INT_MAX)
        	dp[i]=-1;
    }
    cout << dp[N];
}