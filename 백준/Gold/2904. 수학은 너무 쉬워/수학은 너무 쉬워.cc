#include<iostream>
#include<cmath>
#include<vector>
#include<cstring>

using namespace std;

int num[101], tmp[101], N, res=1,res2=0;
bool isp[1000001];
vector<int> pv;

void sieve()
{
	memset(isp, true, sizeof(isp));
	isp[0]=isp[1]=false;
	for(int i=2;i<=sqrt(1000000);i++)
	{
		if(!isp[i])
			continue;
		for(int j=i*2;j<=1000000;j+=i)
			isp[j]=false;
	}
	for(int i=2;i<=1000000;i++)
	{
		if(isp[i])
			pv.push_back(i);
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=1;i<=N;i++)
	{
		cin>>num[i];
		tmp[i]=num[i];
	}
	sieve();
	for(auto p : pv)
	{
		int cnt=0;
		for(int i=1;i<=N;i++)
		{
			while(num[i]%p==0)
			{
				cnt++;
				num[i]/=p;
			}
		}
		res*=pow(p,cnt/N);
		for(int i=1;i<=N;i++)
		{
			int t=0;
			while(tmp[i]%p==0)
			{
				t++;
				tmp[i]/=p;
			}
			if(cnt/N>t)
				res2+=cnt/N-t;
		}
	}
	cout<<res<<' '<<res2;
	return 0;
}