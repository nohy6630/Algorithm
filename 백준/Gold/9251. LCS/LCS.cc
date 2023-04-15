/*
dp[i][j] : 첫문자열에 i번째 두번째문자열에 j번째 문자까지 탐색했을 때 만들어지는 lcs의 길이
a[i]==b[i] 라면 dp[i][j] = dp[i-1][j-1]+1
a[i]!=b[i] 라면 dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
dp[1000][1000]이므로 10^6 즉 0.01초 가 소요되므로 시간복잡도도 ok 
*/
#include<bits/stdc++.h>

using namespace std;

int dp[1001][1001];
string a,b;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>a>>b;
	
	for(int i=1;i<=a.size();i++)
	{
		for(int j=1;j<=b.size();j++)
		{
			if(a[i-1]==b[j-1])
				dp[i][j]=dp[i-1][j-1]+1;
			else
				dp[i][j]=max(dp[i-1][j], dp[i][j-1]);
		}
	}
	cout<<dp[a.size()][b.size()];
}