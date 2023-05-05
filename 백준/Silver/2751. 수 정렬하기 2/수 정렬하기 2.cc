#include<bits/stdc++.h>

using namespace std;

int N;
int num[1000001];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);	
	cin>>N;
	for(int i=1;i<=N;i++)
		cin>>num[i];
	sort(num+1,num+1+N);
	for(int i=1;i<=N;i++)
		cout<<num[i]<<'\n';
}