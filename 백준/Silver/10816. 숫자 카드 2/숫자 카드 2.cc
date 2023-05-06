/*
std::map은 트리로 구현되었기 때문에 map::find의 시간복잡도는 O(logN)이다. 
*/

#include<bits/stdc++.h>

using namespace std;

map<int,int> cnt;
int N,M;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=0;i<N;i++)
	{
		int a;
		cin>>a;
		if(cnt.find(a)!=cnt.end())
			cnt[a]++;
		else
			cnt[a]=1;
	}
	cin>>M;
	for(int i=0;i<M;i++)
	{
		int a;
		cin>>a;
		if(cnt.find(a)!=cnt.end())
			cout<<cnt[a]<<' ';
		else
			cout<<0<<' ';
	}
}