#include<bits/stdc++.h>
#define MOD 1000000000

using namespace std;

int N,K,dp[201][201];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>K;
	memset(dp,0,sizeof(dp));
	for(int i=0;i<=K;i++)
		dp[0][i]=1;
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=K;j++)
		{
			for(int x=0;x<=i;x++)
			{
				if(i-x<0)
					continue;
				dp[i][j]=(dp[i][j]%MOD+dp[i-x][j-1]%MOD)%MOD;
			}
		}
	}
	cout<<dp[N][K];
}