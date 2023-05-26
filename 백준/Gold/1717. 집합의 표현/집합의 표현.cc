/*
경로압축을 이용한 union-find 알고리즘의 시간복잡도의 경우 상수시간이라봐도 무방하다고 한다. 
*/

#include<bits/stdc++.h>

using namespace std;

int N,M;
int p[1000001];

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
	for(int i=0;i<=N;i++)
		p[i]=i;
	for(int i=0;i<M;i++)
	{
		int o,a,b;
		cin>>o>>a>>b;
		if(o==0)
			Union(a,b);
		else
		{
			if(Find(a)==Find(b))//p[a] p[b]를 비교하면 안되고 Find(a) Find(b)를 비교해야 갱신된 집합상태를 비교할수 있음 
				cout<<"YES\n";
			else
				cout<<"NO\n";
		}
	}
	
}