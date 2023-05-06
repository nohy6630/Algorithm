#include<bits/stdc++.h>

using namespace std;

int N,K;
queue<int> Q;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin>>N>>K;
	for(int i=1;i<=N;i++)
		Q.push(i);
	int cnt=0;
	cout<<"<";
	while(Q.size()>1)
	{
		cnt++;
		if(cnt==K)
		{
			cout<<Q.front()<<", ";
			Q.pop();
			cnt=0;
		}
		else
		{
			Q.push(Q.front());
			Q.pop();
		}
	}
	cout<<Q.front()<<">";
}