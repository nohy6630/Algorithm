#include<iostream>
#include<algorithm>

using namespace std;

int N,M;
int budget[10000];

int get_sum(int limit)
{
	int ret=0;
	for(int i=0;i<N;i++)
		ret+=(budget[i]>limit)?limit:budget[i];
	return ret;
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=0;i<N;i++)
		cin>>budget[i];
	cin>>M;
	int mn=*max_element(budget,budget+N);
	int l=0, r=mn, m;
	while(l<=r)
	{
		m=(l+r)/2;
		if(get_sum(m)<=M)
			l=m+1;
		else
			r=m-1;
	}
	mn=(mn>r)?r:mn;
	cout<<mn;
	return 0;
}