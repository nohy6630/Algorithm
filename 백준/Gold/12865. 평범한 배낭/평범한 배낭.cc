/*
knapsack 문제의 대표 형식 
*/
#include<bits/stdc++.h>

using namespace std;

int dp[101][100001];//4*10^7바이트=40mb충분 
int weight[101], value[101];
int N,K; 

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>K;
	for(int i=1;i<=N;i++)
		cin>>weight[i]>>value[i];
	for(int i=1;i<=N;i++)
	{
		for(int j=0;j<weight[i];j++)
			dp[i][j]=dp[i-1][j];
		for(int j=weight[i];j<=K;j++)
			dp[i][j]=max(dp[i-1][j],value[i]+dp[i-1][j-weight[i]]);
	}
	cout<<dp[N][K];
}