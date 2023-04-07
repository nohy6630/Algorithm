#include <iostream>

using namespace std;

int T,K;
int dp[10001], cnt[101], coin[101];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>T>>K;
	for(int i=1;i<=K;i++)
		cin>>coin[i]>>cnt[i];
	dp[0]=1;
	for(int i=1;i<=K;i++)
	{
		for(int j=T;j>=1;j--)
		{
			for(int k=1;k<=cnt[i]&&j-k*coin[i]>=0;k++)
			{
				dp[j]+=dp[j-k*coin[i]];
			}
		}
	}
	cout<<dp[T];
	return 0;
}