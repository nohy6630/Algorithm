#include<iostream>
#include<algorithm>
#include<climits>
using namespace std;

int N;
long long board[100001][4];
long long dp[100001][4];

long long res=LLONG_MAX;
int t=1;

void input()
{
	while(1)
	{
		cin>>N;
		if(N==0)
			return;
		for(int i=1;i<=N;i++)
			for(int j=1;j<=3;j++)
				cin>>board[i][j];
		dp[1][1]=LLONG_MAX;		
		dp[1][2]=board[1][2];
		dp[1][3]=dp[1][2]+board[1][3];
		for(int i=2;i<=N;i++)
		{
			dp[i][1]=board[i][1]+min(dp[i-1][1],dp[i-1][2]);
			dp[i][2]=board[i][2]+min({dp[i-1][1],dp[i-1][2],dp[i-1][3],dp[i][1]});
			dp[i][3]=board[i][3]+min({dp[i-1][2],dp[i-1][3],dp[i][2]});
		}
		if(dp[N][2]<res)
			res=dp[N][2];
		cout<<t<<". "<<res<<'\n';
		t++;
		res=LLONG_MAX;
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	input();
	return 0;
}