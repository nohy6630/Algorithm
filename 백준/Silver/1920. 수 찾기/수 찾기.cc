#include<bits/stdc++.h>

using namespace std;

int N;
int M;
int num[100001];

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=1;i<=N;i++)
		cin>>num[i];
	sort(num+1,num+1+N);
	cin>>M;
	for(int i=1;i<=M;i++)
	{
		int n;
		cin>>n;
		if(binary_search(num+1,num+1+N,n))
			cout<<"1\n";
		else
			cout<<"0\n";
	}
}