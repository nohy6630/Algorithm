#include<bits/stdc++.h>

using namespace std;

int N,K;

int factorial(int n)
{
	if(n==0)
		return 1;
	return n*factorial(n-1);
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>K;
	int ans=factorial(N);
	ans/=factorial(K)*factorial(N-K);
	cout<<ans;
} 