/*
dp[i][j]: i번째 동전까지 사용했을 때 j원을 만드는 경우의 수
dp[i][j] = dp[i][j-cost[i]] + dp[i-1][j]
dp문제는 직접 dp배열이 채워나가는 과정을 수기로 써보면서 점화식을 증명한 후에 코드를 작성하는게 나은거 같기도? 
*/

#include<bits/stdc++.h>

using namespace std;

int N,K;
int dp[10001];
int cost[101];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>K;
	for(int i=1;i<=N;i++)
		cin>>cost[i];
	dp[0]=1;
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=K;j++)
		{
			if(j-cost[i]>=0)
				dp[j]+=dp[j-cost[i]];
		}
	}
	cout<<dp[K];
}