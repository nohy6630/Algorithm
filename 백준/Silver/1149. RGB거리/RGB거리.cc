/*
dp[i][j] : i번째 집까지 색을 칠했고 i번째 집에 j색을 칠했을 때 비용의 최솟값
dp[1][i] = cost[1][i]  
dp[i][0] = min(dp[i-1][1], dp[i-1][2])+cost[i][0]
dp[i][1] = min(dp[i-1][0], dp[i-1][2])+cost[i][1]
dp[i][2] = min(dp[i-1][0], dp[i-1][1])+cost[i][2]
*/
#include<bits/stdc++.h>

using namespace std;

int N;
int cost[1001][3];
int dp[1001][3];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=1;i<=N;i++)
		cin>>cost[i][0]>>cost[i][1]>>cost[i][2];
	for(int i=0;i<3;i++)
		dp[1][i]=cost[1][i];
	for(int i=2;i<=N;i++)
	{
		dp[i][0] = min(dp[i-1][1], dp[i-1][2])+cost[i][0];
		dp[i][1] = min(dp[i-1][0], dp[i-1][2])+cost[i][1];
		dp[i][2] = min(dp[i-1][0], dp[i-1][1])+cost[i][2];
	}
	cout<<min({dp[N][0],dp[N][1],dp[N][2]});
}