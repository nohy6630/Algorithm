#include<bits/stdc++.h>

using namespace std;

priority_queue<int> pq;
int N;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=0;i<N;i++)
	{
		int n;
		cin>>n;
		if(n==0)
		{
			if(pq.empty())
				cout<<0<<'\n';
			else
			{
				cout<<pq.top()<<'\n';
				pq.pop();
			}
		}
		else
		{
			pq.push(n);
		}
	}
	return 0;
}