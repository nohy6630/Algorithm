#include<bits/stdc++.h>

using namespace std;
using ll = long long;

ll dp[31];
int N;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	dp[0]=1;
	for(int i=2;i<=N;i++)
	{
		dp[i]=dp[i-2]*3;
		for(int j=i-4;j>=0;j-=2)
			dp[i]+=dp[j]*2;	
	}
	cout<<dp[N];
}