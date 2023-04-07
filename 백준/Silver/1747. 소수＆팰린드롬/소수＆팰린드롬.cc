#include<iostream>
#include<algorithm>
#include<string>
#include<cmath>
#define MAX 5000000

using namespace std;

bool isp[MAX];
int N;

void sieve()
{
	fill(isp,isp+MAX,true);
	isp[0]=isp[1]=false;
	for(int i=2;i<=sqrt(MAX);i++)
	{
		if(!isp[i])
			continue;
		for(int j=i*i;j<MAX;j+=i)
			isp[j]=false;
	}
}


int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	sieve();
	while(1)
	{
		if(!isp[N])
		{
			N++;
			continue;
		}
		string s=to_string(N);
		int l=0,r=s.size()-1;
		while(l<=r)
		{
			if(s[l]!=s[r])
				break;
			l++;
			r--;
		}
		if(l>r)
			break;
		N++;
	}
	cout<<N;
	return 0;
}