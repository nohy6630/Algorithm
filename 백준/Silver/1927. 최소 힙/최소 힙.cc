#include<bits/stdc++.h>

using namespace std;

priority_queue<int,vector<int>,greater<int>> PQ;
int N;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N;
	for(int i=0;i<N;i++)
	{
		int x;
		cin>>x;
		if(x!=0)
			PQ.push(x);
		else
		{
			if(PQ.empty())
				cout<<0<<'\n';
			else
			{
				cout<<PQ.top()<<'\n';
				PQ.pop();
			}
		}
	}
}