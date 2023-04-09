#include <iostream>
#include <algorithm>

using namespace std;

int N,M,sum=0;
int cost[100001];

bool is_valid(int k)
{
	int cnt=M-1;
	int money=k;
	for(int i=1;i<=N;i++)
	{
		if(money<cost[i])
		{
			cnt--;
			money=k;
		}
		money-=cost[i];
	}
	return cnt>=0;
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	for(int i=1;i<=N;i++)
	{
		cin>>cost[i];
		sum+=cost[i];
	}
	int l=*max_element(cost+1, cost+1+N);
	int r=sum;
	while(l<=r)
	{
		int m=(l+r)/2;
		if(is_valid(m))
			r=m-1;
		else
			l=m+1;
	}
	cout<<l;
	return 0;
}