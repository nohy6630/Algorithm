#include <iostream>
#include <set>
#include <cstring>
#include <cmath>

using namespace std;

int N;
set<int> candys;
int cnt[10001];
bool isp[500001];
long long dp[500001];

void sieve()
{
	memset(isp,true,sizeof(isp));
	isp[0]=isp[1]=false;
	for(int i=2;i<=sqrt(N*10000);i++)
	{
		if(!isp[i])
			continue;
		for(int j=i*2;j<=N*10000;j+=i)
			isp[j]=false;
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=0;i<N;i++)
	{
		int a;
		cin>>a;
		candys.insert(a);
		cnt[a]++;
	}
	sieve();
	dp[0]=1;
	for(auto c:candys)
	{
		for(int i=N*10000;i>=1;i--)
		{
			for(int j=1;j<=cnt[c]&&i-c*j>=0;j++)
				dp[i]+=dp[i-c*j];
		}
	}
	long long res=0;
	for(int i=0;i<=N*10000;i++)
	{
		if(isp[i])
			res+=dp[i];
	}
	cout<<res*(cnt[0]+1);
	return 0;
}