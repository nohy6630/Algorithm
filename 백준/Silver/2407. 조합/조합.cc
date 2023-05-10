/*
nCr = n!/((n-r)!r!)
nCr = n-1Cr-1 + n-1Cr
파스칼의 삼각형도 다이내믹 프로그래밍의 일종이라 볼수 있을 듯 
*/
#include<bits/stdc++.h>

using namespace std; 

int N,M;
string dp[101][101];

string addBigNum(string n1, string n2)
{
	string ret="";
	int sum=0;
	int size=max(n1.size(),n2.size());
	for(int i=0;i<size||sum;i++)
	{
		if(n1.size()>i)
			sum+=n1[i]-'0';
		if(n2.size()>i)
			sum+=n2[i]-'0';
		ret+=sum%10+'0';
		sum/=10;
	}
	return ret;
}

string combination(int n,int r)
{
	//cout<<"combination("<<n<<", "<<r<<")\n";
	if(n==r||r==0)
		return "1";
	if(!dp[n][r].empty())
		return dp[n][r];
	dp[n][r]=addBigNum(combination(n-1,r-1),combination(n-1,r));
	return dp[n][r];
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	string ans=combination(N,M);
	reverse(ans.begin(),ans.end());
	cout<<ans;
}