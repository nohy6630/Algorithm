#include<bits/stdc++.h>

using namespace std;

typedef pair<int,int> pii;

int N;
pii m[100001];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=1;i<=N;i++)
	{
		int a,b;
		cin>>a>>b;
		m[i]={b,a};	
	}
	sort(m+1,m+1+N);
	int cur=0,cnt=0;
	for(int i=1;i<=N;i++)
	{
		if(m[i].second>=cur)
		{
			cur=m[i].first;
			cnt++;
		}
	}
	cout<<cnt<<'\n';
}