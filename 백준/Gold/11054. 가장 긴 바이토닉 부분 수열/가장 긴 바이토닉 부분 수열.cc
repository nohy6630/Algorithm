/*
dp[i] :  1~i번째 숫자에서 증가하고 i+1~에서 감소하는 가장 긴 바이토닉 수열의 길이
lis[i] : 1~i번째로 만들어진 lis 
*/
#include<bits/stdc++.h>

using namespace std;

int N;
int dp[1001];
int dp2[1001];
int A[1001];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=1;i<=N;i++)
		cin>>A[i];
	for(int i=1;i<=N;i++)
	{
		dp[i]=1;
		for(int j=1;j<i;j++)
		{
			if(A[j]<A[i]&&dp[i]<dp[j]+1)
				dp[i]=dp[j]+1;
		}
	}
	for(int i=N;i>=1;i--)
	{
		dp2[i]=1;
		for(int j=N;j>i;j--)
		{
			if(A[i]>A[j]&&dp2[i]<dp2[j]+1)
				dp2[i]=dp2[j]+1;
		}
	}
	int ans=0;
	for(int i=1;i<=N;i++)
	{
		if(ans<dp[i]+dp2[i]-1)
			ans=dp[i]+dp2[i]-1;
	}
	cout<<ans;
}