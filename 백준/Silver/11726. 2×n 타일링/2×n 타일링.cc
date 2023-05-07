#include<bits/stdc++.h>

using namespace std;

int N;
int dp[1001];//dp[i]:i열까지 직사각형을 채울때 생기는 경우의 수를 10007로 나눈 나머지 

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	dp[1]=1;
	dp[2]=2;
	for(int i=3;i<=N;i++)
		dp[i]=(dp[i-1]%10007+dp[i-2]%10007)%10007;
	cout<<dp[N]; 
}