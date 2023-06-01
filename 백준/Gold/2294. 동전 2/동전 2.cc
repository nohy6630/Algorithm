#include<bits/stdc++.h>

using namespace std;

int N,K,dp[101][10001],cost[101];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>K;
	for(int i=1;i<=N;i++)
		cin>>cost[i];
	for(int i=0;i<=N;i++)
	{
		for(int j=0;j<=K;j++)
			dp[i][j]=INT_MAX;
	}
	dp[0][0]=0;
	for(int i=1;i<=N;i++)
	{
		for(int j=0;j<=K;j++)
		{
			dp[i][j]=dp[i-1][j];
			for(int x=1;x<=i;x++)
			{
				if(j-cost[x]<0)
					continue;
				if(dp[x][j-cost[x]]==INT_MAX)
					continue;
				dp[i][j]=min(dp[i][j],dp[x][j-cost[x]]+1);
			}
		}
	}
	if(dp[N][K]==INT_MAX)
		cout<<-1;
	else
		cout<<dp[N][K];
}