#include<bits/stdc++.h>
 
using namespace std;
 
int N,M;
int p[201];

int Find(int a)
{
	if(p[a]==a)
		return a;
	return p[a]=Find(p[a]);
}

void Union(int a, int b)
{
	p[Find(b)]=Find(a);
}
 
int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>M;
	for(int i=1;i<=N;i++)
		p[i]=i;
	for(int i=1;i<=N;i++)
	{
		for(int j=1;j<=N;j++)
		{
			int n;
			cin>>n;
			if(n==1)
				Union(i,j);
		}
	}
	int c;
	cin>>c;
	int tmp=Find(c);
	for(int i=2;i<=M;i++)
	{
		cin>>c;
		if(tmp!=Find(c))
		{
			cout<<"NO";
			return 0;
		}
	}
	cout<<"YES";
}